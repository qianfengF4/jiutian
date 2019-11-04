package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.entity.AfterCourse;
import com.jiutian.jiutian.mapper.InsertCourseMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.AfterCourse1Service;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class InsertCourseServiceImpl extends ServiceImpl<InsertCourseMapper, AfterCourse> implements AfterCourse1Service {
    @Override
    public ResultVo insertCourse(AfterCourse course) {
        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");

        course.setCreatData(new Date());
        course.setTeacherId(admin.getId());
        course.setStatusId(1);
        int insert = getBaseMapper().insert(course);
        if (insert>0){
            return ResultVo.setOk("上传成功");
        }
        return ResultVo.setError("上传失败");
    }
}
