package com.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by chen on 2020/7/13.
 */
public class Person implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware
        , MessageSourceAware,ApplicationContextAware, InitializingBean,DisposableBean{

    public Person(String name) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>init:"+name);
    }

    public void initMethod() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>init-method:发生了");
    }

    public void initDestroy() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>initDestroy:销毁了");
    }

    public void setBeanName(String name) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setBeanName执行了："+name);
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setBeanClassLoader执行了：" + classLoader.getClass());
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setBeanFactory执行了：" + beanFactory.getClass().toString());
    }


    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setResourceLoader执行了：" + resourceLoader.getClass().toString());
    }


    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setApplicationEventPublisher执行了：" + applicationEventPublisher.getClass().toString());

    }

    public void setMessageSource(MessageSource messageSource) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setMessageSource执行了：" + messageSource.getClass().toString());
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>setApplicationContextAware执行了：" + applicationContext.getClass().toString());

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>afterPropertiesSet发生了");
    }

    public void destroy() throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>DisposableBean#Destory()");
    }
}
