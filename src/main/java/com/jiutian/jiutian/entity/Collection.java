package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("collection")
public class Collection {

    @TableId(type = IdType.AUTO)
    private int id;
    private String courseId;
    private String infoId;



}
