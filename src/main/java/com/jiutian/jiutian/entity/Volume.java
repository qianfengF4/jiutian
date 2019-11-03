package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("volume")
public class Volume {

    private int id;
    private String volumeName;
}
