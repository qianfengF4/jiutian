package com.jiutian.jiutian.controller;



import com.jiutian.jiutian.entity.Message;
import com.jiutian.jiutian.service.MessageService;
import com.jiutian.jiutian.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "回家")
public class MessageController {


    @Autowired
    MessageService messageService;

    @GetMapping("/api/message/list.do")
    @ApiOperation(value = "按收入分别")
    public ResultVo messageshow () {

        List<Message> messageList =  messageService.selectMessageAll();
        return ResultVo.setOk(messageList);
    }



}
