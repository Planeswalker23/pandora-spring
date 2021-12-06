package io.walkers.planes.pandora.spring.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * IOC 依赖查找示例
 *
 * @author Planeswalker23
 */
public class IocDependencyLookupTest {

    @Test
    public void lookupByName() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByNameContext.xml");
        User user = (User) applicationContext.getBean("userLookupByName");
        System.out.println("根据 name 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byName", user.getName());
        Assert.assertEquals(1, user.getId().intValue());
    }

    @Test
    public void lookupByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByTypeContext.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println("根据 type 依赖查找结果：" + user);
        Assert.assertEquals("PlanesWalker23-lookup-byType", user.getName());
        Assert.assertEquals(2, user.getId().intValue());
    }

    @Test
    public void lookupByAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyLookupByTypeContext.xml");
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(io.walkers.planes.pandora.spring.ioc.annotation.User.class);
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
