package io.walkers.planes.pandora.spring.ioc.bean.definition;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * BeanDefinition 注册器
 *
 * @author Planeswalker23
 */
@Import(BeanRegister.class)
public class BeanRegisterTest {

    @Test
    public void register() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanRegisterTest.class);

        Bean bean = applicationContext.getBean(Bean.class);
        System.out.println(bean);

        Assert.assertEquals("beanName", bean.getName());
    }
}
