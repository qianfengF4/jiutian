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
    private int id;
    private String mname;
    private String realName;
    private String phoneNum;
    private String sex;
    private Integer provinceId;
    private Integer cityId;
    private Integer countrysideId;
    private String ctime;
    private Integer schoolId;
    private Integer gradeId;
    private String roleName;
    private String courseName;
    private String projectName;
    private String password;
    private String province;
    private String countryside;
    private String city;
    private List<ProjectPart> coursePart;

    private Integer projectId;
    private Integer learningSessionId;
    private Integer flag;
    private Integer roleId;
    private Integer classId;
    private String image = "/media/image/20141219030221_QCNMA.jpg";

}
