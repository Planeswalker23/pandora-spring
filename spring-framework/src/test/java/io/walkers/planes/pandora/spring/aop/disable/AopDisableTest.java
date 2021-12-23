package io.walkers.planes.pandora.spring.aop.disable;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 演示 AOP 失效场景
 *
 * @author Planeswalker23
 */
public class AopDisableTest {

    @Test
    public void invokeMyself() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        AopDisableInvokeMyselfProcessor aopDisableInvokeMyselfProcessor = applicationContext.getBean(AopDisableInvokeMyselfProcessor.class);
        // expect to output 4 lines, actual is 3 lines
        aopDisableInvokeMyselfProcessor.processTwo();
    }

    @Test
    public void invokeMyselfEnableAopByAopContext() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        AopDisableInvokeMyselfProcessor aopDisableInvokeMyselfProcessor = applicationContext.getBean(AopDisableInvokeMyselfProcessor.class);
        // expect to output 4 lines, actual is 4 lines
        // need config = @EnableAspectJAutoProxy(exposeProxy = true)
        aopDisableInvokeMyselfProcessor.processTwoEnableAopByAopContext();
    }

    @Test
    public void invokeMyselfEnableAopByInjectMyself() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        AopDisableInvokeMyselfProcessor aopDisableInvokeMyselfProcessor = applicationContext.getBean(AopDisableInvokeMyselfProcessor.class);
        // expect to output 4 lines, actual is 4 lines
        aopDisableInvokeMyselfProcessor.processTwoEnableAopByInjectMyself();
    }

    @Test
    public void loadBeanAdvance() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        AopDisableLoadBeanAdvanceProcessor aopDisableLoadBeanAdvanceProcessor = applicationContext.getBean(AopDisableLoadBeanAdvanceProcessor.class);
        // expect to output 2 lines, actual is 1 lines
        // 因为 Bean 被提前创建，未被代理
        aopDisableLoadBeanAdvanceProcessor.processOne();
    }

    @Test
    public void invokePrivateMethod() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationAopConfig.class);
        AopDisableInvokePrivateMethod aopDisableInvokePrivateMethod = applicationContext.getBean(AopDisableInvokePrivateMethod.class);
        // expect to output 4 lines, actual is 3 lines
        // AopDisableProcessor#processOne 的前置逻辑，由于其访问权限为 private 而未执行
        // org.springframework.aop.support.AopUtils.canApply(org.springframework.aop.Pointcut, java.lang.Class<?>, boolean)
        aopDisableInvokePrivateMethod.processTwoEnableAopByInjectMyself();
    }
}
