package com.jiutian.jiutian.resultVo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class AdminRVo {
    private int id;
    private String username;
    private String password;
    private String image;
    private String phoneNum;
    private String realName;
    private String gradeName;
    private String projectName;
    private String learnSessionName;

}
