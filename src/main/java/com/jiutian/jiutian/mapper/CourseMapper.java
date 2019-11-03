package com.jiutian.jiutian.mapper;

import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.vo.CourseVo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {

//    @Results(id = "course", value = {
//            @Result(property = "id",column = "id"),
//            @Result(property = "title",column = "title"),
//            @Result(property = "creatData",column = "creatdata"),
//            @Result(property = "gradeId",column = "grade_id"),
//            @Result(property = "learnSessionId",column = "learn_session_id"),
//            @Result(property = "projectId",column = "proect_id"),
//            @Result(property = "playNumber",column = "play_number"),
//            @Result(property = "detail",column = "detail"),
//            @Result(property = "teacherId",column = "teacher_id"),
//            @Result(property = "image",column = "image"),
//            @Result(property = "time",column = "time"),
//            @Result(property = "volume",column = "volume")
//    })
    @Select("select * from course where title = '${value}%'")
    @ResultType(Course.class)
    List<Course> qureyCourse(String ch);


    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.learn_session_id=1 and status_id=2")
    List<CourseVo> selectList1();
    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.grade_id != 13 and c.learn_session_id=2 and status_id=2")
    List<CourseVo> selectList2();
    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.grade_id != 14 and c.learn_session_id=3 and status_id=2")
    List<CourseVo> selectList3();

    @Select("select id,title from course where grade_id=#{gradeId} and project_id=#{projectId} and status_id=2")
    List<CourseVo> selectListCourse(int projectId, int gradeId);


    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.learn_session_id=1 and status_id=2 order by c.play_number desc ")
    List<CourseVo> selectList11();
    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.grade_id != 13 and c.learn_session_id=2 and status_id=2 order by c.play_number desc ")
    List<CourseVo> selectList12();
    @Select("select c.id,c.title,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.grade_id != 14 and c.learn_session_id=3 and status_id=2 order by c.play_number desc ")
    List<CourseVo> selectList13();

    @Select("select c.id,c.title,c.detail,c.image,c.creat_data,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and status_id=2")
    List<CourseVo> selectAllList();

    @Select("select c.id,c.title,c.detail,c.image,c.creat_data,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and c.learn_session_id=#{num} and status_id=2")
    List<CourseVo> selectAllListBynum1(int num);

    @Select("select c.id,c.title,c.detail,c.image,c.creat_data,c.play_number,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id=g.id and c.project_id=p.id and status_id=2 order by c.play_number desc")
    List<CourseVo> selectAllListBynum99();

    @Select("select c.title,c.play_number,c.detail,c.creat_data,g.grade_name,p.project_name from course c,grade g,project p where c.grade_id = g.id and c.project_id = p.id and c.id =#{id}")
    Video selectCourseById(int id);

    @Select("select * from jiutian.course where learn_session_id = #{learnSessionId} order by play_number DESC")
    List <Course> selectCourseByLearnSessionIdDesc(Integer learnSessionId,Model model);

    @Select("select * from jiutian.course order by creat_data DESC ")
    List <Course> selectCourseByTimeDesc(Model model);

    @Select("select * from jiutian.course where learn_session_id = #{learnSessionId} order by creat_data DESC ")
    List <Course> selectCourseByLearnSessionIdTimeDesc(Integer learnSessionId,Model model);



}
