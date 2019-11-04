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



    @Select("select p.prms from jiutian.sys_permission p inner join jiutian.sys_rolepermission rp on "  +
            "p.id=rp.pid inner join jiutian.sys_userrole ur on ur.rid=rp.rid where ur.uid=#{uid} "+
            "and p.type=2 order by p.id")
    @ResultType(String.class)
    List<String> selectPerms(int uid);


    @Insert("insert into jiutian.user(phone_num, real_name, province_id, city_id, " +
            "countryside_id, school_id, project_id, learning_session_id, grade_id," +
            " mname, password, ctime, flag, role_id,image) values (#{phoneNum},#{realName}," +
            "#{provinceId},#{cityId},#{countrysideId},#{schoolId},#{projectId}," +
            "#{learningSessionId},#{gradeId},#{mname},#{password},#{ctime},#{flag},#{roleId},#{image})")
    @SelectKey(keyColumn = "id",keyProperty = "id",resultType = Integer.class,before = false,statement = {"select last_insert_id()"})
    int register(User user);


    @Select("select * from jiutian.user where phone_num = #{phoneNum}")
    @ResultType(String.class)
    User selectUserByPhoneNum(String phoneNum);


    @Select("select * from jiutian.user where user.mname = #{userName}")
    @ResultType(String.class)
    User selectUser(String userName);

    @Select("select * from project")
    List<Project> selectAllProject();
}
