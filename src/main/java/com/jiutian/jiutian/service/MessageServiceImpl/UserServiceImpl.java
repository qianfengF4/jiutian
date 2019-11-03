package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.entity.ProjectPart;
import com.jiutian.jiutian.entity.User;
import com.jiutian.jiutian.mapper.UserDao;
import com.jiutian.jiutian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component(value = "UserDao")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getAllUsers(int id) {
        User user= userDao.getAllUser(id);
        System.out.println(user);
        return user;
    }

    @Override
    public User getAllUser(int id) {
        User user= userDao.getAllUsers(id);
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> getTeacher() {
        return userDao.getTeacher();
    }

    @Override
    public List<Project> getProject(int id) {
        return userDao.getProjectById( id);
    }

    @Override
    public List<ProjectPart> getProjectPart(int id) {
        return userDao.getProjectPartById(id);
    }

    @Override
    public User getUserId(User user) {
        return userDao.getUser(user);
    }


//    @Override
//    public List<User> getUsers() {
//
//        return userDao.getUser();
//    }


}
