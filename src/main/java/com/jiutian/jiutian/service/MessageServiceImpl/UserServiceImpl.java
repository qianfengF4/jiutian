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


    @Autowired
    AdminMapper adminMapper;

    @Override
    public ResultVo login(UserDto userDto) {
        //1、查询用户
        //User user = getBaseMapper().selectOne(new QueryWrapper<User>().eq("mname", userDto.getUsername()));

        User user = getBaseMapper().selectUser(userDto.getUsername());

        System.out.println(user);
        //2、验证账号是否存在
        if(user!=null){
            //3、验证密码
            if(Objects.equals(user.getPassword(),userDto.getPsw())){
                //4、操作Shiro

                // 1.创建主题对象
                Subject subject = SecurityUtils.getSubject();

                // 2.创建令牌 用户名密码令牌
                UsernamePasswordToken token = new UsernamePasswordToken(userDto.getUsername(), userDto.getPsw());

                // 3.存储当前的User
                subject.getSession().setAttribute("curruser",user);

                // 4.登录 告诉Shiro登录成功
                subject.login(token);

                return ResultVo.setOk("OK");
            }
        }
        return ResultVo.setError("失败");
    }

    /*@Override
    public R loginByPhoneNum(User user) {

        User user1 = getBaseMapper().selectOne(new QueryWrapper<User>().eq("phone_num", user.getPhoneNum()));

        System.out.println(user1.getPhoneNum());

        if (user1!=null) {

            // 发送验证码

            SmsUtil.setNewcode();
            String code = Integer.toString(SmsUtil.getNewcode());
            int id = userMapper.insertPhoneNum(user.);


            // 进行验证码比较。正确登录跳index页面，不正确报异常

            return R.setOK("OK");

        }
        return R.setERROR();
    }*/

    @Override
    public ResultVo register(User user) {

        // 判断为 学生（RoleId）注册
        if (user.getRoleId() == 1) {

            // 根据用户名查询学生
            User user2 = getBaseMapper().selectUser(user.getMname());

            if (user2 == null && user.getProvinceId() != null && user.getCityId() != null &&
                    user.getGradeId() != null && user.getClassId() != null &&user.getSchoolId() != null &&
                    user.getCountrysideId() != null) {

                getBaseMapper().register(user);

                return ResultVo.setOk("OK");

            }

        }

        // 判断为 家长（RoleId）注册
        if (user.getRoleId() == 2) {

            // 根据手机号查询家长
            User user3 = getBaseMapper().selectUserByPhoneNum(user.getPhoneNum());

            if (user3 == null) {

                getBaseMapper().register(user);

                return ResultVo.setOk("OK");

            }

        }

        // 判断为 老师（RoleId）注册
        if (user.getRoleId() == 3) {

            // 根据用户电话号查询老师
            User user1 = getBaseMapper().selectUserByPhoneNum(user.getPhoneNum());

            // 如果没有对应的用户,则注册
            if (user1 == null) {

                if (user.getProvinceId() != null && user.getCityId() != null &&
                        user.getGradeId() != null && user.getClassId() != null && user.getSchoolId() != null &&
                        user.getCountrysideId() != null && user.getProjectId()!=null) {

                    getBaseMapper().register(user);

                    int count3 = adminMapper.savaAdmin(user);

                    if (count3 > 0) {

                        return ResultVo.setOk("OK");

                    }

                }

            }

        }

        // 判断为 教研员（RoleId）注册
        if (user.getRoleId() == 4) {

            // 根据手机号查询教研员
            User user4 = getBaseMapper().selectUserByPhoneNum(user.getPhoneNum());

            if (user4 == null && (user.getProvinceId() != null && user.getCityId() != null &&
                    user.getSchoolId() != null &&user.getCountrysideId() != null &&
                    user.getProjectId()!=null && user.getLearningSessionId() != null)) {

                getBaseMapper().register(user);

                int count4 = adminMapper.savaAdmin(user);

                if (count4 > 0) {

                    return ResultVo.setOk("OK");

                }

            }

        }

        // 判断为 专家（RoleId）注册
        if (user.getRoleId() == 5) {

            // 根据手机号查询专家
            User user5 = getBaseMapper().selectUserByPhoneNum(user.getPhoneNum());

            if (user5 == null && (user.getProvinceId() != null && user.getCityId() != null &&
                    user.getGradeId() != null && user.getClassId() != null ||user.getSchoolId() != null &&
                    user.getCountrysideId() != null && user.getProjectId()!=null)) {

                getBaseMapper().register(user);

                int count5 = adminMapper.savaAdmin(user);

                if (count5 > 0) {

                    return ResultVo.setOk("OK");

                }
            }

        }

        return ResultVo.setError("失败");
    }
}
