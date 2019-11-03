package com.jiutian.jiutian.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("course")
public class Course {
    private int id;
    private String title;
    private String creatData;
    private int gradeId;
    private int learnSessionId;
    private int projectId;
    private int playNumber;
    private String detail;
    private int teacherId;
    private String image;
    private int time;
    private int volume;
}

