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
    int id;
    String name;
    int parentId;
    int level;
}
