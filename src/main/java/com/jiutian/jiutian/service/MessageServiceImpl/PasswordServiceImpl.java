package com.jiutian.jiutian.service.MessageServiceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.UserPassword;
import com.jiutian.jiutian.mapper.PasswordDao;
import com.jiutian.jiutian.service.PasswordService;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl extends ServiceImpl<PasswordDao, UserPassword> implements PasswordService {
}
