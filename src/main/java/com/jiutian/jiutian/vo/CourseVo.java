package com.jiutian.jiutian.vo;


import lombok.Data;


@Data
public class CourseVo {
    private int id;
    private String gradeName;
    private String projectName;
    private String title;
    private int playNumber;
    private String creatData;
    private String detail;
    private String image;
    private int teacherId;
    private String teacherName;
    private String videoUrl;
}