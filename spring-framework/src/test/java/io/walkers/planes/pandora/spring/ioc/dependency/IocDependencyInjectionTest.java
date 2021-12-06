package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserHolder;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.AnnotationDrivenIocDependencyInjectionConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 依赖注入示例
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionTest {

    @Test
    public void injectionByXmlConfig() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/injection/IocDependencyInjectionContext.xml");
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("依赖注入 User 结果：" + userHolder);
        Assert.assertEquals("PlanesWalker23-injection", userHolder.getUser().getName());
        Assert.assertEquals(3, userHolder.getUser().getId().intValue());
    }

    @Test
    public void injectionByAnnotationConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationDrivenIocDependencyInjectionConfig.class);
        AnnotationDrivenIocDependencyInjectionConfig bean = applicationContext.getBean(AnnotationDrivenIocDependencyInjectionConfig.class);
        System.out.println("依赖注入 User 结果：" + bean.getUser());
        Assert.assertEquals("PlanesWalker23-injection", bean.getUser().getName());
        Assert.assertEquals(3, bean.getUser().getId().intValue());
    }
}
