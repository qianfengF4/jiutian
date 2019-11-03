package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("grade")
public class Grade {
    private int id;
    private String title;
    private String grade;
    private String project;
    private String learnSession;
    private String gradeName;
}
