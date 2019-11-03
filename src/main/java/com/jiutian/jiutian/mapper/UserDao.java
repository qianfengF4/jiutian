package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.entity.ProjectPart;
import com.jiutian.jiutian.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao extends BaseMapper<User> {
//    @Select("select * from user")
//    @ResultType(User.class)
//    List<User> getUser();
//
    /*获得用户的信息*/
    @Select("select * from user where id =#{id}")
    @ResultType(User.class)
    User getAllUser(int id);

    /*获得用户账号密码*/
    @Select("select * from admin where id =#{id}")
    @ResultType(User.class)
    User getAllUsers(int id);

    @Select("select count(1) from user where mname=#{mname} and password=#{password}")
    int login(User user);

    @Select("select u.*,r.role_name,p.project_name  from role r,user u,project p " +
            " where  u.project_id=p.id and u.role_id= r.id ")
//    @Result(value = {
//            @Result(column = "id",property = "id"),
//            @Result(column = "real_name",property = "realName"),
//            @Result(column = "phone_num",property = "phoneNum"),
//                @Result(column = "projectPart",property = )
//    })
    List<User> getTeacher();


    @Select("select * from project where id=#{id}")
    @Results({
            @Result(property = "id",column = "id",id=true),
            @Result(property = "projectName",column = "project_name"),
            @Result(property = "projectPart",column = "id"
            ,many = @Many(select = "UserDao.getProjectPartById",fetchType = FetchType.EAGER))
    })
    @ResultType(Project.class)
    List<Project> getProjectById(int id);


    @Select("select * from project_part where project_id =#{id}")
    List<ProjectPart> getProjectPartById(int id);

    @Select("select * from user where mname=#{mname}")
    @ResultType(User.class)
    User getUser(User user);
}
