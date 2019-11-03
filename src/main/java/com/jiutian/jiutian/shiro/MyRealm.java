package com.jiutian.jiutian.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {

    // 认证 登录成功 生成票据
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //查询当前登录用户的角色和权限
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
       //登录成功
        if (token.getPassword() != null) {
            AuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),getName());
        return info;
        }
        return null;
    }
}
