package com.jiutian.jiutian.entity;

import lombok.Data;


import java.util.List;

@Data
public  class Menu {

    private int id;
    private String name;
    private String icon;
    private String prms;
    private int type;
    private int level;
    private int parentid;
    private List<Menu> child;


}
