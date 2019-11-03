package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private int id;
    private int roleid;
    private String username;
    private String password;
}
