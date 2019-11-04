package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Volume;
import com.jiutian.jiutian.mapper.AfterVolumeMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterVolumeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AfterVolumeServiceImpl extends ServiceImpl<AfterVolumeMapper, Volume> implements AfterVolumeService {
    @Override
    public ResultVo selectVolume() {
        List<Volume> volumeList = getBaseMapper().selectList(new QueryWrapper<Volume>());
        return ResultVo.setOk(volumeList);
    }
}
