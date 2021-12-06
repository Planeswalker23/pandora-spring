package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionWay1SetterHolder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 依赖注入方式1：setter 属性注入
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay1SetterTest {

    @Test
    public void injectionBySetterOfXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/injection/IocDependencyInjectionWay1SetterContext.xml");
        IocDependencyInjectionWay1SetterHolder bean = applicationContext.getBean(IocDependencyInjectionWay1SetterHolder.class);
        System.out.println("XML 形式的 setter 依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way1-setter-xml", bean.getUser().getName());
        Assert.assertEquals(7, bean.getUser().getId().intValue());
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(8);
        user.setName("PlanesWalker23-injection-way1-setter-annotation");
        return user;
    }

    @Test
    public void injectionBySetterOfAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionWay1SetterTest.class);
        applicationContext.register(IocDependencyInjectionWay1SetterHolder.class);
        IocDependencyInjectionWay1SetterHolder bean = applicationContext.getBean(IocDependencyInjectionWay1SetterHolder.class);
        System.out.println("注解形式的 setter 依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way1-setter-annotation", bean.getUser().getName());
        Assert.assertEquals(8, bean.getUser().getId().intValue());
    }
}
