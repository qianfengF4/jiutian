package com.jiutian.jiutian.mapper;




import com.jiutian.jiutian.entity.Message;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    @Results(id = "message",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "dateTime", column = "date_time"),
            @Result(property = "text", column = "text")

    })
    @Select("select * from message")
    List<Message> selectMessageAll();


}
