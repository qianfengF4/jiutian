package com.jiutian.jiutian.entity;



import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private int id;
    private String title;
    private String dateTime;
    private String text;
}
