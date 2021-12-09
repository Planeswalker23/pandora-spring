package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link BeanPostProcessor} 和 {@link FactoryBean} 示例
 *
 * @author Planeswalker23
 */
public class BeanPostProcessorTest {

    @Test
    public void register() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(FactoryBeanPostProcessor.class);
        applicationContext.register(UserFactoryBean.class);
        applicationContext.refresh();

        User user = applicationContext.getBean(User.class);

        Assert.assertEquals("UserFactoryBean", user.getName());
        applicationContext.close();
    }
}
