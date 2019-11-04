package com.jiutian.jiutian.service.MessageServiceImpl;

import com.jiutian.jiutian.entity.Admin;
import com.jiutian.jiutian.entity.Menu;
import com.jiutian.jiutian.entity.Video;
import com.jiutian.jiutian.mapper.MenuMapper;
import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public ResultVo queryMenu() {

        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        List<Menu> menuList=menuMapper.selectMenuByUid(admin.getRoleId());
        //组装菜单信息
        List<Menu> menus=new ArrayList<>();
        //循环进行菜单内容的组装 安装级别关系
        for(int i=0;i<menuList.size();i++){
            Menu menu=menuList.get(i);
            Menu bean=new Menu();
            bean.setId(menu.getId());
            bean.setChild(new ArrayList<Menu>());
            bean.setName(menu.getName());
            if(menu.getLevel()==1){
                //一级菜单
                menus.add(bean);
            }else if(menu.getLevel()==2){
                //二级菜单
                //先寻找对应的一级菜单
                int index=searhP(menus,menu.getParentid());
                //验证是否找到对应一级菜单
                if(index>=0){
                    //找到了对应的一级菜单
                    Menu menuBean=menus.get(index);
                    //将当前的二级菜单添加到对应的一级菜单下
                    menuBean.getChild().add(bean);
                }
            }
        }
        return ResultVo.setOk(menus);
    }

    @Override
    public ResultVo select(int id) {

        Admin admin= (Admin) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        List<Video> videoList;
        if(id==0){
            videoList=menuMapper.selectVideoByUid1(admin.getId());
            return ResultVo.setOk(videoList);
        }else{
             videoList=menuMapper.selectVideoByUid(admin.getId(),id);
            return ResultVo.setOk(videoList);
        }

    }



    private int searhP(List<Menu> menus, int parentid) {
        for(int i=0;i<menus.size();i++){
            if(menus.get(i).getId()==parentid){
                return i;
            }
        }
        return -1;
    }
}
