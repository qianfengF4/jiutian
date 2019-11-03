package com.jiutian.jiutian.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    int id;
    String mname;
    String realName;
    String phoneNum;
    String sex;
    int provinceId;
    int cityId;
    int countrysideId;
    String ctime;
    int schoolId;
    int gradeId;
    String roleName;
    String courseName;
    String projectName;
    String password;
    String province;
    String countryside;
    String city;
    List<ProjectPart> coursePart;

}
