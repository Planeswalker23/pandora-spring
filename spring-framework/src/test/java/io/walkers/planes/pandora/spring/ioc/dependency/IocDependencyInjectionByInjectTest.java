package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionByInject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;

/**
 * IOC 依赖注入自动注入：基于 {@link Inject} 注解实现注入的逻辑
 *
 * @author PlaINjeker23
 */
public class IocDependencyInjectionByInjectTest {

    @Test
    public void inject() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionByInject.class);
        IocDependencyInjectionByInject bean = applicationContext.getBean(IocDependencyInjectionByInject.class);

        System.out.println("user = " + bean.getUser());
        Assert.assertEquals(20, bean.getUser().getId().intValue());
        Assert.assertEquals("user20", bean.getUser().getName());
    }
}
