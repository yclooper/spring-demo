package com.yclooper.springshiro.config.shiro;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public AuthorizingRealm realm() {
        return new MyRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setCacheManager(new MemoryConstrainedCacheManager());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        //没有登录的时候跳转
        shiroFilterFactoryBean.setLoginUrl("/user/notLogin");
        //没有权限的时候跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/notAuth");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/logout", "anon");
//        filterMap.put("/user/hello","roles[user]");
//        filterMap.put("/user/hi", "roles[admin]");
        filterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 开启注解模式，可以在controller中使用shiro注解
     * @return
     */
    @Bean
    public static DefaultAdvisorAutoProxyCreator  authorizationAttributeSourceAdvisor() {
        return new DefaultAdvisorAutoProxyCreator();
    }
}
