package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.parameterVo.AdminVo;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AdminService extends IService<Admin> {
    ResultVo isLogin(AdminVo adminVo);

    ResultVo selectAdminById();

    ResultVo selectPasswordByAdminId(String password);

    ResultVo updataPasswordByAdminId(String password);
}
