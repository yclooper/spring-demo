package com.bean;

/**
 * Created by chen on 2020/7/13.
 */
public class Person {

    public Person(String name) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>init:"+name);
    }

    public void initMethod() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>init-method:发生了");
    }

    public void destroy() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>destroy:销毁了");
    }
}
