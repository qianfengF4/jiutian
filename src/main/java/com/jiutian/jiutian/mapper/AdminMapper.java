package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.parameterVo.AdminVo;

import com.jiutian.jiutian.resultVo.AdminRVo;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select count(1) from admin where username=#{username} and password=#{password}")
    int isLogin(AdminVo adminVo);

    @Select("select p.prms from sys_permission p inner join " +
        "sys_rolepermission rp on p.id=rp.pid" +
        " inner join admin a on a.role_id=rp.rid" +
        " where a.roleid=#{id} and p.type=2 order by p.id")
    @ResultType(String.class)
    List<String> selectPerms(int id);

    @Select("select a.id,a.username,a.image,u.phone_num,u.id,u.real_name,g.grade_name,p.project_name,ls.learn_session_name" +
            " from admin a , user u,grade g,project p,learn_session ls " +
            "where a.userid=u.id and g.id=u.grade_id and p.id = u.project_id " +
            "and ls.id = u.learning_session_id and a.userid=#{id}")
    AdminRVo selectAdminById(int id);

    @Update("update admin set password=#{password} where id=#{id} ")
    void updataPasswordByAdminId(int id, String password);
}
