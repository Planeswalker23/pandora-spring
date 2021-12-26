package io.walkers.planes.pandora.spring.ioc.bean.definition;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanDefinition 注册示例
 *
 * @author Planeswalker23
 */
public class BeanDefinitionRegisterTest {

    @Test
    public void register() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 定义 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Bean.class);
        beanDefinitionBuilder.addPropertyValue("name", "Planeswalker23");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // 注册 BeanDefinition
        applicationContext.registerBeanDefinition("bean", beanDefinition);
        // 启动 Spring 容器
        applicationContext.refresh();

        Bean bean1 = applicationContext.getBean(Bean.class);
        Bean bean2 = applicationContext.getBean("bean", Bean.class);
        Assert.assertEquals(bean1, bean2);

        BeanDefinition beanDefinitionFromSpring = applicationContext.getBeanDefinition("bean");
        Assert.assertEquals(beanDefinition, beanDefinitionFromSpring);

        // 关闭 Spring 容器
        applicationContext.close();
    }
}
