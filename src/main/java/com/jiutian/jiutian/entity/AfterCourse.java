package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("course")
public class AfterCourse {
    private int id;
    private String title;
    private Date creatData;
    private int gradeId;
    private int learnSessionId;
    private int projectId;
    private int playNumber;
    private String detail;
    private int teacherId;
    private String image;
    private String time;
    private int volume;
    private String videoUrl;
    private int StatusId;

}
