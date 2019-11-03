package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Area;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceDao extends BaseMapper<Area> {

    @Select("select * from area where id=#{id}")
    List<Area> selectProvince(int id);
}
