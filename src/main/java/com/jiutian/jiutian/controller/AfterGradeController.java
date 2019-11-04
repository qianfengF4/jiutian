package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "年级查询",tags = "年级查询")
public class AfterGradeController {
    @Autowired
    AfterGradeService gradeService;
    @PostMapping("/api/after/select/grade")
    @ApiOperation(value = "查询所有年级信息", notes = "查询所有年级信息")
    public ResultVo selectGrade(){

        return gradeService.selectGrade();
    }

}
