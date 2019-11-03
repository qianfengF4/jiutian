package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;

import com.jiutian.jiutian.service.AfterProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "学科查询",tags = "学科查询")
public class AfterProjectController {
    @Autowired
    AfterProjectService projectService;
    @PostMapping("/api/select/project")
    @ApiOperation(value = "查询所有学科", notes = "查询所有学科")
    public ResultVo selectProject(){
        return projectService.selectProject();
    }

}
