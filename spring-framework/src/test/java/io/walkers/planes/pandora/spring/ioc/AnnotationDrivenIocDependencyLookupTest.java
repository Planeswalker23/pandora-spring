package io.walkers.planes.pandora.spring.ioc;

import io.walkers.planes.pandora.spring.ioc.config.AnnotationDrivenIocDependencyLookupConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解驱动的依赖查找
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyLookupTest {

    @Test
    public void delayLookupByType() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationDrivenIocDependencyLookupConfig.class);
        User user = applicationContext.getBean(User.class);
        System.out.println("注解驱动的根据 type 依赖查找 User 类结果：" + user);
        Assert.assertEquals("PlanesWalker23-annotation-drive", user.getName());
        Assert.assertEquals(6, user.getId().intValue());
    }
}
