package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Area;
import com.jiutian.jiutian.mapper.AreaDao;
import com.jiutian.jiutian.mapper.ProvinceDao;
import com.jiutian.jiutian.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl extends ServiceImpl<AreaDao, Area> implements ProvinceService {
   @Autowired
   ProvinceDao provinceDao;

    @Override
    public List<Area> getProvince(int id) {
        return provinceDao.selectProvince(id);
    }
}
