package io.walkers.planes.pandora.spring.ioc.bean.scope;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 作用域
 *
 * @author Planeswalker23
 * @date 2021/12/7
 */
public class IocBeanScopeTest {

    @Test
    public void scope() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册单例 BeanDefinition
        BeanDefinitionBuilder singleton = BeanDefinitionBuilder.genericBeanDefinition(SingletonScopeBean.class);
        singleton.setScope(BeanDefinition.SCOPE_SINGLETON);
        applicationContext.registerBeanDefinition("singleton", singleton.getBeanDefinition());

        // 注册原型 BeanDefinition
        BeanDefinitionBuilder prototype = BeanDefinitionBuilder.genericBeanDefinition(PrototypeScopeBean.class);
        prototype.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        applicationContext.registerBeanDefinition("prototype", prototype.getBeanDefinition());

        applicationContext.refresh();

        // singleton1 == singleton2
        SingletonScopeBean singleton1 = applicationContext.getBean("singleton", SingletonScopeBean.class);
        SingletonScopeBean singleton2 = applicationContext.getBean("singleton", SingletonScopeBean.class);
        Assert.assertEquals(singleton1, singleton2);

        // prototype1 != prototype2
        PrototypeScopeBean prototype1 = applicationContext.getBean("prototype", PrototypeScopeBean.class);
        PrototypeScopeBean prototype2 = applicationContext.getBean("prototype", PrototypeScopeBean.class);
        Assert.assertNotEquals(prototype1, prototype2);

        applicationContext.close();
    }

}
