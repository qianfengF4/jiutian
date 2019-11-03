package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.entity.*;

import com.jiutian.jiutian.service.*;
import com.jiutian.jiutian.utils.RedisUtil;
import com.jiutian.jiutian.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Api(value = "用户管理" ,tags="实现用户各种操作")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AreaService areaService;

    @Autowired
    ProvinceService provinceService;

    @Autowired
    CitySerivce citySerivce;

    @Autowired
    DistService distService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    GradeService gradeService;

    @Autowired
    PwdService pwdService;

    @Autowired
    PasswordService passwordService;

    @Autowired
    CollectionService collectionService;

    @Autowired
    RedisUtil redisUtil;


    @PostMapping("api/login")
    @ApiOperation(value="登陆",notes="登陆")
    public int login(User user, HttpSession session){
        User user1 = userService.getUserId(user);
        System.out.println("user1="+user1.getId());
        session.setAttribute("user",user1.getId());
        return pwdService.login(user);
    }

        @ApiOperation(value="修改用户的信息",notes="修改用户的信息")
        @PostMapping("/user/updateUser2")
        @ResponseBody
        public R getAllCity(User user) {
            System.out.println("user="+user);
            boolean res  = userService.updateById(user);

            return R.setOK(res);
        }

    @ApiOperation(value="展示所有市",notes="展示所有市")
    @GetMapping("/user/showAllCity")
    @ResponseBody
    public List<Area> getAllCity() {

        List<Area> list = areaService.showAllCity();
        System.out.println(list);
        return list;
    }
    @ApiOperation(value="获得所有区",notes="获得所有区")
    @GetMapping("user/allCountry")
    public List<Area> userArea() {
         List<Area> list = areaService.showAllCounty();
        return list;
    }

    @ApiOperation(value="获得所有年级",notes="获得所有年级")
    @GetMapping("user/allGrade")
    public List<Grade> userGrade() {

        List<Grade> list = gradeService.getGrade();

        return list;
    }

    @ApiOperation(value="获得用户所有信息",notes="获得用户所有信息")
    @GetMapping("/user/allInfo")
    @ResponseBody
    public User userInfo(HttpSession session) {
        int id = (int) session.getAttribute("user");
        System.out.println("id="+id);
        User list = userService.getAllUsers(id);

        System.out.println(list);
        return list;
    }

    @ApiOperation(value="获得个人省信息",notes="获得个人省信息")
    @GetMapping("user/province")
    @ResponseBody
    public List<Area> getProVince(int id){
        System.out.println(provinceService.getProvince(id));
        return provinceService.getProvince(id);
    }
    @ApiOperation(value="获得个人城市信息",notes="获得个人城市信息")
    @GetMapping("user/city")
    @ResponseBody
    public List<Area> getCity(int id) {
            return citySerivce.getCity(id);
    }

    @ApiOperation(value="获得个人区信息",notes="获得个人区信息")
    @GetMapping("user/dist")
    @ResponseBody
    public List<Area> getDists(int id) {
            return distService.getDist(id);
    }


//    @ApiOperation(value="获得对应学校信息",notes="获得对应学校信息")
//    @GetMapping("user/school")
//    @ResponseBody
//    public List<School> getSchools(int id) {
//        return schoolService.getSchool(id);
//    }


    @ApiOperation(value="获得对应年级信息",notes="获得年级信息")
    @GetMapping("user/grade")
    @ResponseBody
    public List<Grade> getGrades() {
        return gradeService.getGrade();
    }
    //
    @ApiOperation(value="修改用户信息",notes="获得用户信息")
    @GetMapping("user/updateUser")
    @ResponseBody
    public boolean updateUser(User user) {
        System.out.println("后端已经获取到"+user.getPassword());

        boolean res = userService.updateById(user);
        return res;
    }

    @ApiOperation(value="修改用户密码",notes="获得用户密码")
    @PostMapping("user/updatePassword")
    @ResponseBody
    public R updatePassword(User user) {

        boolean res = userService.updateById(user);
        return R.setResult(res,"修改成功");
    }


    @ApiOperation(value="添加收藏",notes="添加收藏")
    @GetMapping("user/addCourse")
    @ResponseBody
    public boolean updatePassword2(Collection collection) {

        boolean res = collectionService.save(collection);

        return res;
    }

    @ApiOperation(value="展示收藏",notes="展示收藏")
    @GetMapping("user/showCourse")
    @ResponseBody
    public  List<Course> updatePassword3(int id) {

       List<Course> list= collectionService.getCourseById(id);

        return list;
    }

    @ApiOperation(value="展示省",notes="展示省")
    @GetMapping("/user/showProvince")
    @ResponseBody
    public List<Area> getProvince() {
        List<Area> list = areaService.showProvice();
        System.out.println("1:"+list);
        return list;

    }

    @ApiOperation(value="展示市",notes="展示市")
    @GetMapping("/user/showCity")
    @ResponseBody
    public List<Area> getCity2(int id) {

        List<Area> list = areaService.showCity(id);
        System.out.println(list);
        return list;
    }


    @ApiOperation(value="展示区",notes="展示区")
    @GetMapping("/user/showCounty")
    @ResponseBody
    public List<Area> getDist2(int id) {

        return areaService.showCounty(id);

    }

    @ApiOperation(value="展示老师课程",notes="展示老师课程")
    @GetMapping("/user/showTeacher")
    @ResponseBody
    public List<User> getDist3() {

        return userService.getTeacher();

    }

    @ApiOperation(value="展示老师科目下的课程",notes="展示老师科目下的课程")
    @GetMapping("/user/showProjectPart")
    @ResponseBody
    public List<Project> getProjectPart(int id) {

        return userService.getProject(id);

    }


    @ApiOperation(value="展示课程",notes="展示课程")
    @GetMapping("user/showProject")
    @ResponseBody
    public List<ProjectPart> getProject(int id) {

        return userService.getProjectPart(id);

    }
    @ApiOperation(value="上传图片",notes="上传图片")
    @GetMapping("user/upLoadImage")
    @ResponseBody
    public List<ProjectPart> upImage(MultipartFile image_file,HttpSession session) {

       // return userService.getProjectPart();
        return  null;
    }


//    //查询当前登录用户的菜单信息
//    @ApiOperation(value="查询当前登录用户的菜单信息",notes="查询当前登录用户的菜单信息")
//    @GetMapping(value = "/api/user/queryMenu.do")
//    @ResponseBody
//    public String queryMenu(){
//        System.out.println("12");
//        return "回到了";
//        //return userService.queryMenu();
//    }
@PostMapping("/api/user/login.do")
@ApiOperation(value = "登录")
public ResultVo login(UserDto userDto){

    System.out.println(userDto.getUsername());

    return userService.login(userDto);

}


    @PostMapping("/api/send/message.do")
    @ApiOperation(value = "发送短信验证码")
    public ResultVo code(String phoneNumber){

        SmsUtils.setNewcode();

        int newcode = SmsUtils.getNewcode();

        String code = Integer.toString(newcode);

        try {

            SendSmsResponse response = SmsUtils.sendSms(phoneNumber, code);

        } catch (ClientException e) {

            e.printStackTrace();

            return ResultVo.setError("发送失败");

        }

        return ResultVo.setOk(code);
    }

    @PostMapping("/api/user/register.do")
    @ApiOperation(value = "用户注册")
    public ResultVo register(User user) {

        return userService.register(user);

    }


}
