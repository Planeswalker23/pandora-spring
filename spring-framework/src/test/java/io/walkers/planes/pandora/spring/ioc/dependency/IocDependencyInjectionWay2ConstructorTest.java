package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionWay2ConstructorHolder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 依赖注入方式2：构造器属性注入
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay2ConstructorTest {

    @Test
    public void injectionByConstructorOfXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/injection/IocDependencyInjectionWay2ConstructorContext.xml");
        IocDependencyInjectionWay2ConstructorHolder bean = applicationContext.getBean(IocDependencyInjectionWay2ConstructorHolder.class);
        System.out.println("XML 形式的构造器依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way2-constructor-xml", bean.getUser().getName());
        Assert.assertEquals(9, bean.getUser().getId().intValue());
    }

    @Bean
    public User user() {
        return new User(10, "PlanesWalker23-injection-way2-constructor-annotation");
    }

    @Test
    public void injectionByConstructorOfAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionWay2ConstructorTest.class);
        applicationContext.register(IocDependencyInjectionWay2ConstructorHolder.class);
        IocDependencyInjectionWay2ConstructorHolder bean = applicationContext.getBean(IocDependencyInjectionWay2ConstructorHolder.class);
        System.out.println("注解形式的构造器依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way2-constructor-annotation", bean.getUser().getName());
        Assert.assertEquals(10, bean.getUser().getId().intValue());
    }
}
