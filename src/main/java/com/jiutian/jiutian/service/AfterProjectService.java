package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterProjectService extends IService<Project> {
    ResultVo selectProject();
}
