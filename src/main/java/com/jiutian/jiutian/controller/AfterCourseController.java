package com.jiutian.jiutian.controller;


import com.jiutian.jiutian.entity.AfterCourse;

import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCourse1Service;
import com.jiutian.jiutian.service.AfterCourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;


@RestController
@Api(value = "后台课程管理",tags = "后台课程管理")
public class AfterCourseController {
    @Autowired
    AfterCourseService courseService;
    @Autowired
    AfterCourse1Service insertCourse;
    @PostMapping("/delectCourseById")
    @ApiOperation(value = "通过id删除课程", notes = "通过id删除课程")
    public ResultVo delectCourseById(int id){
        courseService.removeById(id);
        return ResultVo.setOk("删除成功") ;
    }


    @PostMapping("/deleteCourseByIds")
    @ApiOperation(value = "通过ids批量删除课程", notes = "通过ids批量删除课程")
    public ResultVo deleteCourseByIds(String ids){
        String[] split = ids.split("\"");
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <split.length ; i++) {
            if ((i%2)!=0){
                Integer integer = Integer.valueOf(split[i]);
                integers.add(integer);
            }
        }
        return courseService.removeCourseByIds(integers);
    }
    @PostMapping("/api/insert/course")
    @ApiOperation(value = "通过id添加课程", notes = "通过id添加课程")
    public ResultVo insertCourse(AfterCourse course){
        System.out.println(course.getVideoUrl());
        return insertCourse.insertCourse(course) ;
    }


}
