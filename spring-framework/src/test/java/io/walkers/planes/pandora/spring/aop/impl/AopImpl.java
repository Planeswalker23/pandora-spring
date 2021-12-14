package io.walkers.planes.pandora.spring.aop.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于 AspectJ 实现 AOP
 *
 * @author Planeswalker23
 */
public class AopImpl {

    @Test
    public void byXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/aop/impl/aop-impl.xml");
        AddService addService = applicationContext.getBean(AddService.class);
        int source = 1;
        int result = addService.plusOne(source);
        Assert.assertEquals(1 + 1, result);
    }
}
