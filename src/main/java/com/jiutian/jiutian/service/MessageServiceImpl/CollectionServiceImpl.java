package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Collection;
import com.jiutian.jiutian.entity.Course;
import com.jiutian.jiutian.mapper.CollectionDao;
import com.jiutian.jiutian.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionDao, Collection> implements CollectionService {

    @Autowired
    CollectionDao collectionDao;

    @Override
    public List<Course> getCourseById(int id) {
        return  collectionDao.getCourseById(id);
    }



}
