package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.School;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SchoolDao extends BaseMapper<School> {

    @Select("select * from school where dist_id = #{id}")
    @ResultType(School.class)
    List<School> getSchools(int id);
}
