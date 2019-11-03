package com.jiutian.jiutian.utils;

import org.springframework.util.DigestUtils;

public class Md5Utils {

    /*
        MD5加密算法：是一种非常普遍，不可逆的算法，安全性非常高
        1、如果项目中使用了Spring框架，可以直接使用spring自带的工具类
        2、也可以去下载MD5加密的jar包
        3、如果觉得jar包太大了，可以直接复制一个md5源码
     */

    public static String getMd5Str(String mingWen){

        String firstMi = DigestUtils.md5DigestAsHex(mingWen.getBytes());
        String jieStr = firstMi.substring(5,16);
        String salt = "laoyan";
        String newStr = firstMi+jieStr+salt;
        return DigestUtils.md5DigestAsHex(newStr.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getMd5Str("123"));
    }
}
