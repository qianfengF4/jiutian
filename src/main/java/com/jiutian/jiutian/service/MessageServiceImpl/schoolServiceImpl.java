package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.School;
import com.jiutian.jiutian.mapper.SchoolDao;
import com.jiutian.jiutian.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class schoolServiceImpl extends ServiceImpl<SchoolDao, School> implements SchoolService {
    @Autowired
    SchoolDao schoolDao;
    @Override
    public List<School> getSchool(int id) {
        return schoolDao.getSchools(id);
    }
}
