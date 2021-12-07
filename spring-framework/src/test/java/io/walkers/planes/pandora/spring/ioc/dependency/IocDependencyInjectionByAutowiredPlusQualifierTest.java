package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionByAutowiredPlusQualifier;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC 依赖注入自动注入：基于 {@link Autowired} + {@link Qualifier} 注解进行限定注入(分组注入)
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionByAutowiredPlusQualifierTest {

    @Test
    public void byAutowiredPlusQualifier() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionByAutowiredPlusQualifier.class);
        IocDependencyInjectionByAutowiredPlusQualifier bean = applicationContext.getBean(IocDependencyInjectionByAutowiredPlusQualifier.class);

        System.out.println("user = " + bean.getAutowiredUser());
        Assert.assertEquals(14, bean.getAutowiredUser().getId().intValue());
        Assert.assertEquals("user14", bean.getAutowiredUser().getName());

        System.out.println("allUsers = " + bean.getAutowiredUsers());
        Assert.assertEquals(3, bean.getAutowiredUsers().size());
        Assert.assertEquals(14, bean.getAutowiredUsers().get(0).getId().intValue());
        Assert.assertEquals(15, bean.getAutowiredUsers().get(1).getId().intValue());
        Assert.assertEquals(16, bean.getAutowiredUsers().get(2).getId().intValue());

        System.out.println("qualifierUsers = " + bean.getQualifierUsers());
        Assert.assertEquals(1, bean.getQualifierUsers().size());
        Assert.assertEquals(16, bean.getQualifierUsers().get(0).getId().intValue());

        System.out.println("qualifierCustomUsers = " + bean.getQualifierCustomUsers());
        Assert.assertEquals(1, bean.getQualifierCustomUsers().size());
        Assert.assertEquals(15, bean.getQualifierCustomUsers().get(0).getId().intValue());

    }
}
