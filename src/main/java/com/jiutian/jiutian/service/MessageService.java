package com.jiutian.jiutian.service;

import com.jiutian.jiutian.entity.Message;
import com.jiutian.jiutian.vo.ResultVo;

import java.util.List;

public interface MessageService {
    List<Message> selectMessageAll();

}
