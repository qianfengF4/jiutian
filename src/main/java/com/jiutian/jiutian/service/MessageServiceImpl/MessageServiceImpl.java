package com.jiutian.jiutian.service.MessageServiceImpl;


import com.jiutian.jiutian.mapper.MessageMapper;
import com.jiutian.jiutian.entity.Message;
import com.jiutian.jiutian.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl  implements MessageService {

    @Autowired
    MessageMapper messageMapper;


    @Override
    public List<Message> selectMessageAll() {
        List<Message> list = messageMapper.selectMessageAll();
        return list;
    }

}


