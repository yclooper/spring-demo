package com.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by chen on 2020/7/13.
 */
public class MyImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean b1 = registry.containsBeanDefinition("com.color.Red");
        boolean b2 = registry.containsBeanDefinition("com.color.Yellow");
        if (b1 && b2) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition("com.color.Blue");
            registry.registerBeanDefinition("blue", rootBeanDefinition);
        }
    }
}
