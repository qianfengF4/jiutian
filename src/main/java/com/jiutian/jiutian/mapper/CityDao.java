package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Area;
import com.jiutian.jiutian.entity.City;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityDao extends BaseMapper<Area> {

    @Select("select * from area where id = #{id}")
    @ResultType(City.class)
    List<Area> getCitys(int id);

}
