package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.LearnSession;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterLearnSessionService extends IService<LearnSession> {
    ResultVo selectLearnSession();
}
