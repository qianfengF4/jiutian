package com.jiutian.jiutian.service.MessageServiceImpl;

import com.jiutian.jiutian.entity.User;
import com.jiutian.jiutian.mapper.UserDao;
import com.jiutian.jiutian.service.PwdService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PwdServiceImpl implements PwdService {
    @Autowired
    private UserDao userDao;
    @Override
    public int login(User user) {

        if(userDao.login(user)>0) {
            System.out.println("进来了");
            org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(user.getMname(),user.getPassword());

            subject.login(token);
            return 1;
        }
        System.out.println("出阿里了");
        return 0;
    }
}
