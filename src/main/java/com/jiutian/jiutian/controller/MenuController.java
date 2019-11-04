package com.jiutian.jiutian.controller;


import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(value = "左侧菜单",tags = "左侧菜单")
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping("/api/after/menu")
    @ApiOperation(value = "权限查询左菜单", notes = "权限查询左菜单")
    public ResultVo queryMenu(){

        return  menuService.queryMenu();
    }

    @PostMapping("/api/after/menu/select")
    @ApiOperation(value = "查询用户的课程视频", notes = "查询用户的课程视频")
    public ResultVo select(int id){
        return  menuService.select(id);
    }

}
