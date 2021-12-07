package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionByResource;
import io.walkers.planes.pandora.spring.ioc.dependency.injection.IocDependencyInjectionByResource2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * IOC 依赖注入自动注入：基于 {@link Resource} 注解实现注入的逻辑
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionByResourceTest {

    @Test(expected = BeanCreationException.class)
    public void sameNameDifferentType() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionByResource.class);
        IocDependencyInjectionByResource bean = applicationContext.getBean(IocDependencyInjectionByResource.class);
        // 注入 User 的 Bean 和 UserHolder 类型不一致
    }

    @Test
    public void differentNameSameType() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocDependencyInjectionByResource2.class);
        IocDependencyInjectionByResource2 bean = applicationContext.getBean(IocDependencyInjectionByResource2.class);

        System.out.println("UserBean = " + bean.getUserBean());
        Assert.assertEquals(18, bean.getUserBean().getId().intValue());
        Assert.assertEquals("userBean", bean.getUserBean().getName());
    }
}
