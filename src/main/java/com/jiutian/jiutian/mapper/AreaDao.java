package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Area;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AreaDao extends BaseMapper<Area> {
    @Select("select * from area a where level=1")
    List<Area> getProvince();

    @Select("select * from area a where a.level=2 and parent_id=#{id} ")
    List<Area> getCity(int id);

    @Select("select * from area a where a.level=3 and parent_id=#{id} ")
    List<Area> getCounty(int id);


    @Select("select * from area a where a.level=2  ")
    List<Area> getAllCity();

    @Select("select * from area a where a.level=3 ")
    List<Area> getAllCounty();



    @Select("select name from area where id = #{id}")
    String getAreaById(int id);
}
