package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;

import com.jiutian.jiutian.service.AfterVolumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "册查询",tags = "册查询")
public class AfterVolumeController {
    @Autowired
    AfterVolumeService volumeService;
    @PostMapping("/api/select/volume")
    @ApiOperation(value = "查询上下册", notes = "查询上下册")
    public ResultVo selectVolume(){
        return volumeService.selectVolume();
    }

}
