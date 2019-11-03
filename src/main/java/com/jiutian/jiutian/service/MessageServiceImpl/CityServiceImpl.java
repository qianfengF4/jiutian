package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Area;
import com.jiutian.jiutian.mapper.AreaDao;
import com.jiutian.jiutian.mapper.CityDao;
import com.jiutian.jiutian.service.CitySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl extends ServiceImpl<AreaDao, Area> implements CitySerivce {

    @Autowired
    CityDao cityDao;

    @Override
    public List<Area> getCity(int id) {
        return cityDao.getCitys(id);
    }
}
