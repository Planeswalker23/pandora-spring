package io.walkers.planes.pandora.spring.aop.impl.annotation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 XML 实现 AOP
 *
 * @author Planeswalker23
 */
public class AopImplementByAnnotation {

    @Test
    public void byAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        SubtractService subtractService = applicationContext.getBean(SubtractService.class);
        int source = 1;
        int result = subtractService.subtractOne(source);
        Assert.assertEquals(0, result);
    }

    @Test(expected = RuntimeException.class)
    public void exception() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        SubtractService subtractService = applicationContext.getBean(SubtractService.class);
        subtractService.exception();
    }

    @Test
    public void annotationExpression() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        SubtractService subtractService = applicationContext.getBean(SubtractService.class);
        subtractService.annotatedMethod();
    }

    @Test
    public void invokeMyself() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        SubtractService subtractService = applicationContext.getBean(SubtractService.class);
        subtractService.annotatedMethod2();
    }
}
