package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Area;

import java.util.List;

public interface ProvinceService extends IService<Area> {


    List<Area> getProvince(int id);
}
