package com.jiutian.jiutian.config;

import com.jiutian.jiutian.shiro.MyRealm;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public DefaultWebSecurityManager creatSM(MyRealm realm){
        return new DefaultWebSecurityManager(realm);
    }
    @Bean
    public ShiroFilterFactoryBean creatSF(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        factoryBean.setLoginUrl("/after/login.html");
        factoryBean.setSuccessUrl("/after/index1.html");
        factoryBean.setUnauthorizedUrl("/error.html");

        Map<String, String> map = new HashMap<>();
        map.put("/after/login.html","anon");
        map.put("/api/admin/login.do","anon");
        //静态资源 放行
        map.put("/media/**","anon");
        //全部拦截
        map.put("/api/after/**","authc");
        map.put("/after/**","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
