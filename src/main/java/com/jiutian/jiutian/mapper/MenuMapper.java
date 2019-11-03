package com.jiutian.jiutian.mapper;


import com.jiutian.jiutian.entity.Menu;
import com.jiutian.jiutian.entity.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuMapper  {
    @Select("select p.* from sys_permission p inner join" +
            " sys_rolepermission rp on p.id=rp.pid " +
            "inner join role ur on ur.id=rp.rid " +
            "where ur.id=#{id} and p.type=1 order by p.level,p.id ")
    @ResultType(Menu.class)
    List<Menu> selectMenuByUid(int id);

    @Select("select c.id,title,detail,creat_data,play_number,time,status " +
            "from course c,status s " +
            "where c.status_id=s.id " +
            "and teacher_id=#{id}" +
            " and status_id=#{statusId}")
    List<Video> selectVideoByUid(int id, int statusId);

    @Select("select c.id,title,detail,creat_data,play_number,time,status " +
            "from course c,status s where c.status_id=s.id and teacher_id=#{id}")
    @ResultType(Video.class)
    List<Video> selectVideoByUid1(int id);
}
