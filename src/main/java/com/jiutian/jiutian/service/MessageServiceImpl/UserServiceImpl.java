package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.dto.UserDto;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.entity.ProjectPart;
import com.jiutian.jiutian.entity.User;
import com.jiutian.jiutian.mapper.AdminMapper;
import com.jiutian.jiutian.mapper.UserDao;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.UserService;
import com.jiutian.jiutian.utils.RedisUtil;
import com.jiutian.jiutian.utils.UUIDUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service
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



    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public ResultVo login(UserDto userDto, HttpSession session) {

        User user = getBaseMapper().selectUser(userDto.getUsername());

        //2、验证账号是否存在
        if(user!=null){
            //3、验证密码
            if(Objects.equals(user.getPassword(),userDto.getPsw())){
                session.setAttribute("user",user.getId());
                String uuid = UUIDUtils.getUUID();
                redisUtil.set(userDto.getUsername(),uuid);
                return ResultVo.setOk(uuid);
            }
        }
        return ResultVo.setError("失败");
    }


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

    @Override
    public ResultVo isLogin(String username, String token) {
        Object s = redisUtil.get(username);
        System.out.println(s);
        if (s!=null){
            String str=(String)s;
            System.out.println(str);
            if (str.equals(token)){
                return ResultVo.setOk("OK");
            }
        }
        return ResultVo.setError("未登录");
    }

    @Override
    public ResultVo selectAllProject() {
        List<Project> projectList = userDao.selectAllProject();
        return ResultVo.setOk(projectList) ;
    }
}
