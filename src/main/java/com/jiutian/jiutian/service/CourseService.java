package com.jiutian.jiutian.service;

import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.resultVo.ResultVo;


import java.util.List;

public interface CourseService {

    Course qureyCourse(String ch);

    ResultVo selectList1();

    ResultVo selectList2();

    ResultVo selectList3();

    ResultVo selectListCourse(int projectId, int gradeId);

    ResultVo selectList11();

    ResultVo selectList12();

    ResultVo selectList13();

    ResultVo selectAllList(int num);

    ResultVo selectAllListBynum(int num);

    ResultVo selectCourseById(int id);

    List <Course> selectCourseByLearnSessionIdDesc(Integer learnSessionId);

    List <Course> selectCourseByTimeDesc();

    List <Course> selectCourseByLearnSessionIdTimeDesc(Integer learnSessionId );

    ResultVo selectCourseXCById(int id);
}
