package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.resultVo.ResultVo;

import java.util.ArrayList;


public interface AfterCourseService extends IService<Video> {
    ResultVo removeCourseByIds(ArrayList<Integer> ids);


}
