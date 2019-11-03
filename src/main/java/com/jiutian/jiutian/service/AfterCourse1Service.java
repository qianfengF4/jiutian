package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.AfterCourse;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterCourse1Service extends IService<AfterCourse> {
    ResultVo insertCourse(AfterCourse course);
}
