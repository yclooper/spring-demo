package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2020/7/13.
 */
@Component
public class Dog {
    @Autowired
    public Cat cat;
    public Dog() {
        System.out.println("dog constructor...");
    }
}
