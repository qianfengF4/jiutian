package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("project_part")
public class ProjectPart implements Serializable {
   private int id ;
   private String PartName;

}
