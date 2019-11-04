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
    private int roleId;
    private String username;
    private String password;
    private String image = "/media/image/20141219030221_QCNMA.jpg";
    private int userId;

}
