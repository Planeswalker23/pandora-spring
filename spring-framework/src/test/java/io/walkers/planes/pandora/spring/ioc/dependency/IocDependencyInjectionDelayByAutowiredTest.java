package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionDelayByAutowired;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 延迟依赖注入：基于 {@link ObjectProvider} 实现延迟依赖注入
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionDelayByAutowiredTest {

    @Test
    public void delay() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionDelayByAutowired.class);
        IocDependencyInjectionDelayByAutowired bean = applicationContext.getBean(IocDependencyInjectionDelayByAutowired.class);

        User user = bean.getUserObjectProvider().getObject();
        System.out.println("user = " + user);
        Assert.assertEquals(21, user.getId().intValue());
        Assert.assertEquals("user21", user.getName());
    }
}
