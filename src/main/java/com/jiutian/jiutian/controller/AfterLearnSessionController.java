package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;

import com.jiutian.jiutian.service.AfterLearnSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "学段查询",tags = "学段查询")
public class AfterLearnSessionController {

    @Autowired
    AfterLearnSessionService learnSessionService;
    @PostMapping("/api/after/select/learnSession")
    @ApiOperation(value = "查询所有学段", notes = "查询所有学段")
    public ResultVo selectLearnSession(){
        return learnSessionService.selectLearnSession();
    }
}
