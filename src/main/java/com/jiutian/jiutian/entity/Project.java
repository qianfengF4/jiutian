package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project")
public class Project {
    private int id;
    private String projectName;
}
