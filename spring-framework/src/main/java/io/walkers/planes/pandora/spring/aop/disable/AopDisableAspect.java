package io.walkers.planes.pandora.spring.aop.disable;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 用于演示 AOP 失效场景的增强业务
 *
 * @author Planeswalker23
 */
@Aspect
@Component
public class AopDisableAspect {

    @Before("execution(public void io.walkers.planes.pandora.spring.aop.disable.AopDisableInvokeMyselfProcessor.*(..))")
    public void beforeByAnnotation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.printf("方法[%s]的前置逻辑执行\n", methodName);
    }
}
