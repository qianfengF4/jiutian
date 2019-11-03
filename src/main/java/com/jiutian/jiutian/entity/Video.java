package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Video {
    @TableId(type = IdType.AUTO)
    private int id;
    private String title;
    private String creatData;
    private String detail;
    private int playNumber;
    private int time;
    private String status;
}
