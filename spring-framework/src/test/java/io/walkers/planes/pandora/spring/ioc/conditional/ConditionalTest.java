package io.walkers.planes.pandora.spring.ioc.conditional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;

/**
 * {@link Condition} 使用示例
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
public class ConditionalTest {

    @Test
    public void containsBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConditionalTrueConfig.class);

        applicationContext.refresh();
        // 容器中存在 DependencyBean，ConditionBean 会被注入
        ConditionBean bean = applicationContext.getBean(ConditionBean.class);
        Assert.assertNotNull(bean);

        applicationContext.close();
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void alreadyExistBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ConditionalFalseConfig.class);
        applicationContext.refresh();

        // 容器中无 DependencyBean，ConditionBean 不会被注入
        ConditionBean bean = applicationContext.getBean(ConditionBean.class);

        applicationContext.close();
    }

    @Test
    public void registerBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册过 DependencyBean 后，ConditionBean 也会被注入
        applicationContext.registerBean(DependencyBean.class);
        applicationContext.register(ConditionalFalseConfig.class);
        applicationContext.refresh();

        ConditionBean bean = applicationContext.getBean(ConditionBean.class);
        Assert.assertNotNull(bean);

        applicationContext.close();
    }
}
