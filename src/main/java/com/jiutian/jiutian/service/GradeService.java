package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Grade;

import java.util.List;

public interface GradeService extends IService<Grade> {

    public List<Grade> getGrade();
}
