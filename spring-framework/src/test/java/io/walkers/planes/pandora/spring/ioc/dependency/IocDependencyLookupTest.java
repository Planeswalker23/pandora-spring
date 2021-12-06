package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.annotation.Person;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserWithAnnotation;
import io.walkers.planes.pandora.spring.ioc.dependency.lookup.AnnotationDrivenIocDependencyLookupByAnnotationConfig;
import io.walkers.planes.pandora.spring.ioc.dependency.lookup.AnnotationDrivenIocDependencyLookupByNameConfig;
import io.walkers.planes.pandora.spring.ioc.dependency.lookup.AnnotationDrivenIocDependencyLookupByTypeConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * IOC 依赖查找示例
 *
 * @author Planeswalker23
 */
public class IocDependencyLookupTest {

    @Test
    public void lookupByNameByXmlConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByNameContext.xml");
        User user = (User) applicationContext.getBean("userLookupByName");
        System.out.println("根据 name 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byName", user.getName());
        Assert.assertEquals(1, user.getId().intValue());
    }

    @Test
    public void lookupByNameByAnnotationConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationDrivenIocDependencyLookupByNameConfig.class);
        User user = (User) applicationContext.getBean("userLookupByName");
        System.out.println("根据 name 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byName", user.getName());
        Assert.assertEquals(1, user.getId().intValue());
    }

    @Test
    public void lookupByTypeByXmlConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByTypeContext.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println("根据 type 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byType", user.getName());
        Assert.assertEquals(2, user.getId().intValue());
    }

    @Test
    public void lookupByTypeByAnnotationConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationDrivenIocDependencyLookupByTypeConfig.class);
        User user = applicationContext.getBean(User.class);
        System.out.println("根据 type 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byType", user.getName());
        Assert.assertEquals(2, user.getId().intValue());
    }

    @Test
    public void lookupByAnnotationByXmlConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByTypeContext.xml");
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Person.class);
        beansWithAnnotation.forEach((name, obj) -> {
            if ("userWithAnnotation".equals(name)) {
                UserWithAnnotation userWithAnnotation = (UserWithAnnotation) obj;
                System.out.println("根据注解依赖查找结果：" + userWithAnnotation);
                Assert.assertEquals("PlanesWalker23-lookup-byAnnotation", userWithAnnotation.getName());
                Assert.assertEquals(4, userWithAnnotation.getId().intValue());
            }
        });
    }

    @Test
    public void lookupByAnnotationByAnnotationConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationDrivenIocDependencyLookupByAnnotationConfig.class);
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Person.class);
        beansWithAnnotation.forEach((name, obj) -> {
            if ("userWithAnnotation".equals(name)) {
                UserWithAnnotation userWithAnnotation = (UserWithAnnotation) obj;
                System.out.println("根据注解依赖查找结果：" + userWithAnnotation);
                Assert.assertEquals("PlanesWalker23-lookup-byAnnotation", userWithAnnotation.getName());
                Assert.assertEquals(4, userWithAnnotation.getId().intValue());
            }
        });
    }
}
