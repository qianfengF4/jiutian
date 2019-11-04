package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Grade;
import com.jiutian.jiutian.mapper.AfterGradeMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterGradeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AfterGradeServiceImpl extends ServiceImpl<AfterGradeMapper, Grade> implements AfterGradeService {
    @Override
    public ResultVo selectGrade() {
        List<Grade> grades = getBaseMapper().selectList(new QueryWrapper<Grade>());
        return ResultVo.setOk(grades);
    }
}
