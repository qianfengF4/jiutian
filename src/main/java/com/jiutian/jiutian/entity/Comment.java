package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment")
public class Comment {
    private int id;
    private String text;
    private int courseId;
    private int parentId;
    private int userId;

}
