package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Comment;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterCommentService extends IService<Comment> {
    ResultVo selectCommentById(int id);
}
