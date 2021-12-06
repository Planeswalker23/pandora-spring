package io.walkers.planes.pandora.spring.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 依赖注入示例
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionTest {

    @Test
    public void injection() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/injection/IocDependencyInjectionContext.xml");
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println("依赖注入 User 结果：" + userHolder);
        Assert.assertEquals("PlanesWalker23-injection", userHolder.getUser().getName());
        Assert.assertEquals(3, userHolder.getUser().getId().intValue());
    }
}
