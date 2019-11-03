package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Volume;
import com.jiutian.jiutian.resultVo.ResultVo;

public interface AfterVolumeService extends IService<Volume> {
    ResultVo selectVolume();
}
