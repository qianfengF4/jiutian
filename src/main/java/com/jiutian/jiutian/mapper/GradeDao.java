package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Grade;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GradeDao extends BaseMapper<Grade> {


    @Select("select * from grade")
    @ResultType(Grade.class)
    List<Grade> getGrade();
}
