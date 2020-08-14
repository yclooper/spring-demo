package com.config;

import com.bean.Cat;
import com.bean.Person;
import com.compent.MyBeanProcessor;
import com.condition.LinuxCondition;
import com.condition.MyImportBeanDefinitionRegister;
import com.condition.WindowsCondition;
import org.springframework.context.annotation.*;


/**
 * Created by chen on 2020/7/13.
 */
@Configuration
@ComponentScan(value = "com.bean")
//@Import({com.color.Red.class,com.color.Yellow.class, MyImportBeanDefinitionRegister.class})
public class MainConfig {

    @Bean
    @Lazy
    public Cat cat() {
        return new Cat();
    }
//    @Conditional(WindowsCondition.class)
//    @Bean("bill")
//    public Person bill() {
//        return new Person("bill");
//    }
//    @Bean("linus")
//    @Conditional(LinuxCondition.class)
//    public Person linus() {
//        return new Person("linus");
//    }
    @Bean
    public MyBeanProcessor MyBeanProcessor() {
        return new MyBeanProcessor();
    }
    @Bean(initMethod = "initMethod",destroyMethod = "initDestroy")
    public Person person() {
        return new Person("卡卡罗特");
    }
}
