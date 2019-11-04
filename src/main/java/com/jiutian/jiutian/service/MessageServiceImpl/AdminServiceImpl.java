package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.mapper.AdminMapper;
import com.jiutian.jiutian.parameterVo.AdminVo;
import com.jiutian.jiutian.resultVo.AdminRVo;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
   @Autowired
   AdminMapper adminMapper;
    @Override
    public ResultVo isLogin(AdminVo adminVo) {
        if (adminVo==null||adminVo.getPassword()==null||adminVo.getUsername()==null){
            return ResultVo.setError("用户名或密码不能为空");
        }
        Admin admin = getBaseMapper().selectOne(new QueryWrapper<Admin>().eq("username", adminVo.getUsername()));
        if (adminMapper.isLogin(adminVo)==1){
            Subject subject = SecurityUtils.getSubject();
            //2、创建令牌 用户名密码令牌
            UsernamePasswordToken token = new UsernamePasswordToken(adminVo.getUsername(), adminVo.getPassword());
             subject.getSession().setAttribute("curruser",admin);
            //3、登录 告诉Shiro登录成功
            subject.login(token);
            return ResultVo.setOk("OK");
        }
        return ResultVo.setError("用户名或密码错误");

    }

    @Override
    public ResultVo selectAdminById() {
        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        AdminRVo adminRVo = adminMapper.selectAdminById(admin.getId());
        return ResultVo.setOk(adminRVo);
    }

    @Override
    public ResultVo selectPasswordByAdminId(String password) {
        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        AdminRVo adminRVo = adminMapper.selectAdminById(admin.getId());
        if (adminRVo.equals(password)){
            return ResultVo.setOk("密码正确");
        }
        return ResultVo.setError("密码错误");
    }

    @Override
    public ResultVo updataPasswordByAdminId(String password) {
        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        adminMapper.updataPasswordByAdminId(admin.getId(),password);
        return ResultVo.setOk("修改成功");
    }
}
