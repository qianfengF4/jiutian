package com.jiutian.jiutian.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.entity.ProjectPart;
import com.jiutian.jiutian.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

//    public List<User> getUsers();
//


    User getAllUsers(int id);

    User getAllUser(int id);

    List<User> getTeacher();

    List<Project> getProject(int id);

    List<ProjectPart> getProjectPart(int id);

    User getUserId(User user);
}
