package io.walkers.planes.pandora.spring.aop.impl.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于 AspectJ 注解实现的 AOP
 * <p>
 * 增强顺序：@Around -> @Before -> @AfterReturning -> @After -> @Around
 * <p>
 * 若抛出异常：@Around -> @Before -> @AfterThrowing -> @After(此处 @Around 后半部分不会执行，因为抛异常了)
 *
 * @author Planeswalker23
 */
@Aspect
@Component
public class LoggerAopByAnnotation {

    @Pointcut("execution(public int io.walkers.planes.pandora.spring.aop.impl.annotation.SubtractService.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void before() {
        System.out.println("增强逻辑...before");
    }

    @Before("@annotation(io.walkers.planes.pandora.spring.aop.impl.annotation.Log)")
    public void beforeByAnnotation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.printf("被@Log注解标记的方法[%s]专有的增强逻辑...before\n", methodName);
    }

    @After("pointCut()")
    public void after() {
        System.out.println("增强逻辑...after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("增强逻辑...afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("增强逻辑...afterThrowing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("增强逻辑...around-beforeExecute");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("增强逻辑...around-afterExecute");
        return proceed;
    }
}
