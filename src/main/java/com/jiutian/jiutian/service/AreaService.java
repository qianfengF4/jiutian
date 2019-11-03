package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Area;

import java.util.List;

public interface AreaService extends IService<Area> {


    List<Area> showProvice();

    List<Area> showCity(int id);
    List<Area> showCounty(int id);
    List<Area> showAllCounty();
    List<Area> showAllCity();

    String getAreaById(int id);

}
