package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Area;
import com.jiutian.jiutian.mapper.AreaDao;
import com.jiutian.jiutian.mapper.DistDao;
import com.jiutian.jiutian.service.DistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistServiceImpl extends ServiceImpl<AreaDao, Area> implements DistService {
    @Autowired
    DistDao distDao;

    @Override
    public List<Area> getDist(int id) {
        return distDao.getDists(id);
    }
}
