package com.compent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by chen on 2020/8/14.
 */
public class MyBeanProcessor implements BeanPostProcessor {


    public MyBeanProcessor() {
        System.out.println(">>>>>>>>>>>>this is myBeanprocessor");
    }
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>postProcessBeforeInitialization：" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>postProcessAfterInitialization：" + beanName);
        return bean;
    }
}
