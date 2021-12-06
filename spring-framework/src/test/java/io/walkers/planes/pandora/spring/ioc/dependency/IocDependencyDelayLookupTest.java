package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserHolder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * IOC 延迟依赖查找 {@link ObjectProvider} 示例
 * 防止找不到 Bean 时的报错
 *
 * @author Planeswalker23
 */
public class IocDependencyDelayLookupTest {

    @Test
    public void delayLookupByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/ioc/dependency/lookup/IocDependencyDelayLookupByTypeContext.xml");
        User user = applicationContext.getBean(User.class);
        System.out.println("根据 type 实时依赖查找 User 类结果：" + user);
        Assert.assertEquals("PlanesWalker23-delay-lookup-byType", user.getName());
        Assert.assertEquals(5, user.getId().intValue());

        ObjectProvider<UserHolder> userHolderObjectProvider = applicationContext.getBeanProvider(UserHolder.class);
        System.out.println("根据 type 延迟依赖查找 UserHolder 类结果：" + userHolderObjectProvider.getIfAvailable());
        Assert.assertNull(userHolderObjectProvider.getIfAvailable());

        System.out.println("根据 type 延迟依赖查找 UserHolder 类结果 + Supplier 兜底：" + userHolderObjectProvider.getIfAvailable(UserHolder::new));
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        userHolderObjectProvider.ifAvailable(System.out::println);
        Assert.assertNotNull(userObjectProvider.getObject());
    }
}
