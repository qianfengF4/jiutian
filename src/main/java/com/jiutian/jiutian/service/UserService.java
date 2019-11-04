package com.jiutian.jiutian.service;

import com.jiutian.jiutian.dto.UserDto;
import com.jiutian.jiutian.entity.Project;
import com.jiutian.jiutian.entity.ProjectPart;
import com.jiutian.jiutian.entity.User;
import com.jiutian.jiutian.resultVo.ResultVo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    User getUserId(User user);

    boolean updateById(User user);

    User getAllUsers(int id);

    List<User> getTeacher();

    List<Project> getProject(int id);

    List<ProjectPart> getProjectPart(int id);

    ResultVo login(UserDto userDto, HttpSession session);

    ResultVo register(User user);

    ResultVo isLogin(String username, String token);

    ResultVo selectAllProject();
}
