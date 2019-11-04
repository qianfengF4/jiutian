package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Comment;
import com.jiutian.jiutian.mapper.AfterCommentMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterCommentServiceImpl extends ServiceImpl<AfterCommentMapper, Comment> implements AfterCommentService {
    @Override
    public ResultVo selectCommentById(int id) {
        List<Comment> commentList = getBaseMapper().selectList(new QueryWrapper<Comment>().eq("course_id", id));
        if (commentList.size()>1){
            return ResultVo.setOk(commentList);
        }else{
            return ResultVo.setOk("暂时没有该视频相关评论");

        }
    }
}
