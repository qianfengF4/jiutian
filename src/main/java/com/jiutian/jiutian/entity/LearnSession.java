package com.jiutian.jiutian.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("learn_session")
public class LearnSession {
    private int id;
    private String learnSessionName;
}
