package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Grade;
import com.jiutian.jiutian.mapper.GradeDao;
import com.jiutian.jiutian.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeDao, Grade> implements GradeService {
@Autowired
GradeDao gradeDao;

    @Override
    public List<Grade> getGrade() {
        return gradeDao.getGrade();
    }

}
