package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "后台页面查看评论",tags = "后台页面查看评论")
public class AfterCommentController {
    @Autowired
    AfterCommentService commentService;
    @PostMapping("/api/select/comment")
    @ApiOperation(value = "通过视频id查看评论", notes = "通过视频id查看评论")
    public ResultVo selectCommentById(int id){
        return commentService.selectCommentById(id);
    }

}
