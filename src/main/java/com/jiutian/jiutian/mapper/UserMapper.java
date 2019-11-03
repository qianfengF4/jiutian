package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Permission;
import com.jiutian.jiutian.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {


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

}
