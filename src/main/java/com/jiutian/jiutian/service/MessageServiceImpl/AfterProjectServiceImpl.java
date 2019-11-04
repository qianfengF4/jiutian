package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.mapper.AfterProjectMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterProjectServiceImpl extends ServiceImpl<AfterProjectMapper, Project> implements AfterProjectService {
    @Override
    public ResultVo selectProject() {
        List<Project> projectList = getBaseMapper().selectList(new QueryWrapper<Project>());

        return ResultVo.setOk(projectList);
    }
}
