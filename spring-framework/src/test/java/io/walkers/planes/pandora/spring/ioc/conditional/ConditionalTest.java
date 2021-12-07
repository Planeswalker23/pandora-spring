package io.walkers.planes.pandora.spring.ioc.conditional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;

/**
 * {@link Condition} 使用示例
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
public class ConditionalTest {

    @Bean
    @Conditional(ExistDependencyBeanCondition.class)
    public ConditionBean newConditionBean() {
        return new ConditionBean();
    }

    @Test
    public void missingConditionBeanCondition() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册单例 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(DependencyBean.class);
        applicationContext.registerBeanDefinition("dependencyBean", beanDefinitionBuilder.getBeanDefinition());

        applicationContext.register(ConditionalTest.class);
        applicationContext.refresh();

        ConditionBean bean = applicationContext.getBean(ConditionBean.class);
        Assert.assertNotNull(bean);

        applicationContext.close();
    }



    @Test
    public void alreadyExistBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalTest.class);
        ConditionBean bean = applicationContext.getBean(ConditionBean.class);
        Assert.assertNull(bean);
    }
}
