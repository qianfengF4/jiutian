package com.jiutian.jiutian.service.MessageServiceImpl;

import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.mapper.CourseMapper;
import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.service.CourseService;
import com.jiutian.jiutian.vo.CourseVo;
import com.jiutian.jiutian.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course qureyCourse(String ch) {
//        ch = "\"" + ch+ "%\"";
        System.out.println(ch);
        List<Course> courseList = courseMapper.qureyCourse(ch);

        // List<Course> courseList = courseDao.qureyCourse(ch);
       // System.out.println(courseList.size());
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
        Video video = courseMapper.selectCourseById(id);
        return ResultVo.setOk(video);
    }
}
