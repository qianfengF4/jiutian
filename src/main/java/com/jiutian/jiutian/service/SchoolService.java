package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.School;

import java.util.List;

public interface SchoolService extends IService<School> {
    List<School> getSchool(int id);
}
