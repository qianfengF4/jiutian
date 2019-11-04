package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.LearnSession;
import com.jiutian.jiutian.mapper.AfterLearnSessionMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterLearnSessionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterLearnSessionServiceImpl extends ServiceImpl<AfterLearnSessionMapper, LearnSession> implements AfterLearnSessionService {
    @Override
    public ResultVo selectLearnSession() {
        List<LearnSession> learnSessions = getBaseMapper().selectList(new QueryWrapper<LearnSession>());
        return ResultVo.setOk(learnSessions);
    }
}
