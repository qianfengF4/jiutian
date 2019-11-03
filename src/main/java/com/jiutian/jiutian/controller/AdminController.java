package com.jiutian.jiutian.controller;


import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.parameterVo.AdminVo;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AdminService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "后台管理登录",tags = "后台管理登录")
public class AdminController {

    @Autowired
    AdminService adminService;
    @PostMapping("/api/admin/login.do")
    @ApiOperation(value = "用于验证后台管理登录", notes = "用于验证后台管理登录")
    public ResultVo login(AdminVo adminVo){
        return adminService.isLogin(adminVo);
    }

    @PostMapping("/api/select/admin")
    @ApiOperation(value = "用于查询后台管理信息", notes = "用于查询后台管理信息")
    public ResultVo selectAdminById(){
        return adminService.selectAdminById();
    }

    @PostMapping("/isOK")
    @ApiOperation(value = "用于后台管理密码修改时原密码验证", notes = "用于后台管理密码修改时原密码验证")
    public ResultVo isOK(String password){

        return adminService.selectPasswordByAdminId(password);
    }
    @PostMapping("/reset")
    @ApiOperation(value = "用于后台管理密码修改", notes = "用于后台管理密码修改")
    public ResultVo reset(String password){

        return adminService.updataPasswordByAdminId(password);
    }
}
