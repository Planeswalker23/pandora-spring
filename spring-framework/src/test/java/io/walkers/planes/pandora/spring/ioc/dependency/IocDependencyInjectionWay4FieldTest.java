package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionWay4MethodHolder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * IOC 依赖注入方式2：构造器属性注入
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay4FieldTest {

    @Bean
    public User user() {
        User user = new User();
        user.setId(13);
        user.setName("PlanesWalker23-injection-way4-method-annotation");
        return user;
    }

    @Test
    public void injectionByFieldOfAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionWay4FieldTest.class);
        applicationContext.register(IocDependencyInjectionWay4MethodHolder.class);
        IocDependencyInjectionWay4MethodHolder bean = applicationContext.getBean(IocDependencyInjectionWay4MethodHolder.class);
        System.out.println("注解形式的字段依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way4-method-annotation", bean.getUser().getName());
        Assert.assertEquals(13, bean.getUser().getId().intValue());
    }
}
