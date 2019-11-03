package com.jiutian.jiutian.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiutian.jiutian.entity.Collection;
import com.jiutian.jiutian.entity.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionDao extends BaseMapper<Collection> {
/*获得用户收藏的信息*/
@Select("select c.*,s.title from collection c,course s " +
        " where c.course_id = s.id and c.user_id=#{id}")
    List<Course> getCourseById(int id);
}
