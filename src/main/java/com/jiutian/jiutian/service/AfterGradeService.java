package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Grade;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterGradeService extends IService<Grade> {
    ResultVo selectGrade();
}
