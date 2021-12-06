package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionWay3FieldHolder;
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
public class IocDependencyInjectionWay3FieldTest {

    @Test
    public void injectionByFieldOfXml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/injection/IocDependencyInjectionWay3FieldContext.xml");
        IocDependencyInjectionWay3FieldHolder bean = applicationContext.getBean(IocDependencyInjectionWay3FieldHolder.class);
        System.out.println("XML 形式的字段依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way3-field-xml", bean.getUser().getName());
        Assert.assertEquals(11, bean.getUser().getId().intValue());
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(12);
        user.setName("PlanesWalker23-injection-way3-field-annotation");
        return user;
    }

    @Test
    public void injectionByFieldOfAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionWay3FieldTest.class);
        applicationContext.register(IocDependencyInjectionWay3FieldHolder.class);
        IocDependencyInjectionWay3FieldHolder bean = applicationContext.getBean(IocDependencyInjectionWay3FieldHolder.class);
        System.out.println("注解形式的字段依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection-way3-field-annotation", bean.getUser().getName());
        Assert.assertEquals(12, bean.getUser().getId().intValue());
    }
}
