package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.mapper.CourseMapper;
import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.mapper.UserDao;
import com.jiutian.jiutian.mapper.UserMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.CourseService;
import com.jiutian.jiutian.vo.CourseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course qureyCourse(String ch) {

        System.out.println(ch);
        List<Course> courseList = courseMapper.qureyCourse(ch);

        return courseList.get(0);
    }

    @Override
    public ResultVo selectList1() {
        List<CourseVo> courseList = courseMapper.selectList1();
        return ResultVo.setOk(courseList);
    }

    @Override
    public ResultVo selectList2() {
        List<CourseVo> courseList = courseMapper.selectList2();
        return ResultVo.setOk(courseList);
    }
    @Override
    public ResultVo selectList3() {
        List<CourseVo> courseList = courseMapper.selectList3();
        return ResultVo.setOk(courseList);
    }

    @Override
    public ResultVo selectListCourse(int projectId, int gradeId) {
        List<CourseVo> courseList = courseMapper.selectListCourse(projectId,gradeId);

        if (courseList.size()>4){
            List<CourseVo> courseVos = courseList.subList(0, 4);
            return ResultVo.setOk(courseVos);
        }
        return ResultVo.setOk(courseList);
    }


    @Override
    public ResultVo selectList11() {
        List<CourseVo> courseList = courseMapper.selectList11();
        return ResultVo.setOk(courseList);
    }

    @Override
    public ResultVo selectList12() {
        List<CourseVo> courseList = courseMapper.selectList12();
        return ResultVo.setOk(courseList);
    }
    @Override
    public ResultVo selectList13() {
        List<CourseVo> courseList = courseMapper.selectList13();
        return ResultVo.setOk(courseList);
    }

    @Override
    public ResultVo selectAllList(int num) {

        List<CourseVo> courseList = courseMapper.selectAllList();

        if (courseList.size()-10*num > 10){
            List<CourseVo> courseVos = courseList.subList(0, num*10+10);
            return ResultVo.setOk(courseVos);
        }
        return ResultVo.setOk(courseList);
    }

    @Override
    public ResultVo selectAllListBynum(int num) {
        if (num==0){
            ResultVo resultVo = selectAllList(0);
            return resultVo;

        }else if (num < 8){
            //小学
            List<CourseVo> courseList = courseMapper.selectAllListBynum1(num);
            List<CourseVo> courseVos = subListVo(courseList.size(), courseList);
            return ResultVo.setOk(courseVos);
        }
            //最热
            List<CourseVo> courseList = courseMapper.selectAllListBynum99();
            List<CourseVo> courseVos = subListVo(courseList.size(), courseList);
            return ResultVo.setOk(courseVos);


    }

    private List<CourseVo> subListVo(int size,List<CourseVo> courseList){
        if (size > 10){
            List<CourseVo> courseVos = courseList.subList(0,10);
            return courseVos;
        }
        return courseList;
    }

    @Override
    public ResultVo selectCourseById(int id) {
         CourseVo course = courseMapper.selectCourseById(id);
        return ResultVo.setOk(course);
    }



    @Override
    public List<Course> selectCourseByLearnSessionIdDesc(Integer learnSessionId) {

        List<Course> courseListBySessionIdDesc = getBaseMapper().selectCourseByLearnSessionIdDesc(learnSessionId);



        return courseListBySessionIdDesc;
    }

    @Override
    public List<Course> selectCourseByTimeDesc() {

        List<Course> courseListByTimeDesc = getBaseMapper().selectCourseByTimeDesc();


        return courseListByTimeDesc;
    }

    @Override
    public List<Course> selectCourseByLearnSessionIdTimeDesc(Integer learnSessionId) {

        List<Course> selectCourseByLearnSessionIdTimeDesc = getBaseMapper().selectCourseByLearnSessionIdTimeDesc(learnSessionId);


        return selectCourseByLearnSessionIdTimeDesc;
    }

    @Override
    public ResultVo selectCourseXCById(int id) {
        CourseVo course = courseMapper.selectCourseXCById(id);
        String teacherName = courseMapper.selectUserById(course.getTeacherId());
        course.setTeacherName(teacherName);
        return ResultVo.setOk(course);
    }

}
