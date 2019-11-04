package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("area")
public class Area implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;
    private String name;
    private int parentId;
    private int level;
}
