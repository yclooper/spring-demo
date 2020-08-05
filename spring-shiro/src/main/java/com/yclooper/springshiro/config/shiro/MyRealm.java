package com.yclooper.springshiro.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    private final Map<String, String> pwMap=new HashMap<>();
    private final Map<String,String> roleMap=new HashMap<>();
    {
        pwMap.put("张三", "123456");
        pwMap.put("李四", "137246");

        roleMap.put("张三", "admin");
        roleMap.put("李四", "user");
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        String username = ((String) subject.getPrincipal());
        String role = roleMap.get(username);
        Set<String> roleSet = new HashSet<>();
        roleSet.add(role);
        authorizationInfo.setRoles(roleSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token == null||token.getUsername()==null) {
            throw new AccountException("没有此账户");
        }
        String password = pwMap.get(token.getUsername());
        if (password == null) {
            throw  new UnknownAccountException("没有此账户");
        }
        return new SimpleAuthenticationInfo(token.getUsername(), pwMap.get(token.getUsername()), getName());
    }
}
