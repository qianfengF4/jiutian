package com.jiutian.jiutian.vo;

import com.jiutian.jiutian.entity.Grade;
import lombok.Data;

import java.util.List;
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
}