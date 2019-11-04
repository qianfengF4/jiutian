package com.jiutian.jiutian.controller;


import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "关于课程的查询功能")
public class CourseController {


    @Autowired
    CourseService courseService;

    @GetMapping("/api/course/qureyCourse.do")
    @ApiOperation(value = "首页课程的模糊查询")

    public ResultVo query(String ch) {
        System.out.println(ch);
        Course voList = courseService.qureyCourse(ch);
        return ResultVo.setOk(voList);
    }
    @GetMapping("/api/select/list1.do")
    @ApiOperation(value = "查询小学课程")

    public ResultVo selectList1() {

        return courseService.selectList1();
    }

    @GetMapping("/api/select/list2.do")
    @ApiOperation(value = "查询初中课程")

    public ResultVo selectList2() {

        return courseService.selectList2();
    }
    @GetMapping("/api/select/list3.do")
    @ApiOperation(value = "查询高中课程")

    public ResultVo selectList3() {

        return courseService.selectList3();
    }
    @PostMapping("/api/select/listCourse.do")
    @ApiOperation(value = "查询中考高考相关课程")

    public ResultVo selectListCourse(int projectId,int gradeId) {

        return courseService.selectListCourse(projectId,gradeId);
    }

    @GetMapping("/api/select/list11.do")
    @ApiOperation(value = "排序查询小学课程")

    public ResultVo selectList11() {

        return courseService.selectList11();
    }

    @GetMapping("/api/select/list12.do")
    @ApiOperation(value = "排序查询初中课程")

    public ResultVo selectList12() {

        return courseService.selectList12();
    }
    @GetMapping("/api/select/list13.do")
    @ApiOperation(value = "排序查询高中课程")

    public ResultVo selectList13() {

        return courseService.selectList13();
    }
    @GetMapping("/api/select/allList.do")
    @ApiOperation(value = "查询所有课程")
    public ResultVo selectAllList(int num){
        return courseService.selectAllList(num);
    }
    @GetMapping("/api/select/allListBynum.do")
    @ApiOperation(value = "按条件查询课程")
    public ResultVo selectAllListBynum(int num){
        return courseService.selectAllListBynum(num);
    }

    @GetMapping("/api/select/courseById")
    @ApiOperation(value = "通过id删除课程", notes = "通过id删除课程")
    public ResultVo selectCourseById(int id){

        return courseService.selectCourseById(id) ;
    }

    @PostMapping("/api/course/selectCourseByLearnSessionIdDesc")
    @ApiOperation(value = "最热降序根据学段id展示课程信息")
    public ResultVo selectCourseByLearnSessionIdDesc(Integer learnSessionId) {

        List<Course> courseList4 = courseService.selectCourseByLearnSessionIdDesc(learnSessionId);

        System.out.println("最热降序根据学段id展示课程信息：" + courseList4 );

        if (courseList4 != null) {

            return ResultVo.setOk("OK");
        }
        return ResultVo.setError("失败");

    }

    @PostMapping("/api/course/selectCourseByTimeDesc")
    @ApiOperation(value = "根据创建时间降序展示课程信息")
    public ResultVo selectCourseByTimeDesc() {

        List<Course> courseList5 = courseService.selectCourseByTimeDesc();

        System.out.println("根据创建时间降序展示课程信息：" + courseList5 );

        if (courseList5 != null) {

            return ResultVo.setOk("OK");
        }
        return ResultVo.setError("失败");

    }

    @PostMapping("/api/course/selectCourseBySessionIdTimeDesc")
    @ApiOperation(value = "根据学段id选出来之后进行时间降序展示课程信息")
    public ResultVo selectCourseBySessionIdTimeDesc(Integer learnSessionId) {

        List<Course> courseList6 = courseService.selectCourseByLearnSessionIdTimeDesc(learnSessionId);

        System.out.println("根据学段id选出来之后进行时间降序展示课程信息：" + courseList6 );

        if (courseList6 != null) {

            return ResultVo.setOk("OK");
        }
        return ResultVo.setError("失败");

    }

    @GetMapping("/api/select/courseXCById")
    @ApiOperation(value = "通过id删除课程", notes = "通过id删除课程")
    public ResultVo selectCourseXCById(int id){

        return courseService.selectCourseXCById(id) ;
    }

}
