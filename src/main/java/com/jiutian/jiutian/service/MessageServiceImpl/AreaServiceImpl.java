package com.jiutian.jiutian.service.MessageServiceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiutian.jiutian.entity.Area;
import com.jiutian.jiutian.mapper.AreaDao;
import com.jiutian.jiutian.service.AreaService;
import com.jiutian.jiutian.utils.JsonUtils;
import com.jiutian.jiutian.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl extends ServiceImpl<AreaDao, Area> implements AreaService {
    @Autowired
    AreaDao areaDao;



    @Autowired
    RedisUtil redisUtil;


    @Override
    public List<Area> showProvice() {

        List<Area> list = null;

        String area = (String) redisUtil.get("province");
        if(area!=null&&!area.equals("")) {
            System.out.println("从redis里面取province");
            list = JsonUtils.jsonToList(area, Area.class);
        }else {
            System.out.println("从数据库取ProVic");
            list=areaDao.getProvince();
            redisUtil.set("province", JsonUtils.objectToJson(list));
        }


        return list;

    }
    @Override
    public List<Area> showCity(int id) {

        return areaDao.getCity(id);
    }

    @Override
    public List<Area> showCounty(int id) {

        return areaDao.getCounty(id);
    }

    @Override
    public List<Area> showAllCounty() {


        List<Area> list = null;

        String area = (String) redisUtil.get("country");
        if(area!=null&&!area.equals("")) {
            System.out.println("从redis里面取country");
            list = JsonUtils.jsonToList(area, Area.class);
        } else {
            list=areaDao.getAllCounty();
            System.out.println("qu country from 数据库");
            redisUtil.set("country", JsonUtils.objectToJson(list));
        }


        return list;

    }

    @Override
    public List<Area> showAllCity() {

        List<Area> list = null;

        String area = (String) redisUtil.get("city");
        if(area!=null&&!area.equals("")) {
            list = JsonUtils.jsonToList(area, Area.class);
            System.out.println("从redis里面取city");
        } else {
            System.out.println("从数据库查city");
            list=areaDao.getAllCity();
            redisUtil.set("city", JsonUtils.objectToJson(list));
        }

        return list;
    }

    @Override
    public String getAreaById(int id) {
        return areaDao.getAreaById(id);
    }
}
