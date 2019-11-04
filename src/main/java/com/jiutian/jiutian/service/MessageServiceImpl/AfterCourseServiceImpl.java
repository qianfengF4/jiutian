package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.mapper.AfterCourseMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCourseService;

import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AfterCourseServiceImpl extends ServiceImpl<AfterCourseMapper, Video> implements AfterCourseService {


    @Override
    public ResultVo removeCourseByIds(ArrayList<Integer> ids) {
        int result = getBaseMapper().deleteBatchIds(ids);
        if (result>0){
            return ResultVo.setOk("删除成功");
        }
        return ResultVo.setError("删除失败");
    }

}
