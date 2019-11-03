package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Collection;
import com.jiutian.jiutian.entity.Course;

import java.util.List;

public interface CollectionService extends IService<Collection> {

        List<Course>  getCourseById(int id);
}
