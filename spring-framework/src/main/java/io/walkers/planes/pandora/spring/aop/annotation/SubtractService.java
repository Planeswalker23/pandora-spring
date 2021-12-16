package io.walkers.planes.pandora.spring.aop.annotation;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * 自减-1
 *
 * @author Planeswalker23
 */
@Component
public class SubtractService {

    public int subtractOne(int source) {
        System.out.println("SubtractService#subtractOne...source = " + source);
        source -= 1;
        return source;
    }

    public int exception() {
        System.out.println("SubtractService#exception");
        return 1 / 0;
    }

    @Log
    public void annotatedMethod() {
        System.out.println("SubtractService#annotatedMethod");
    }

    @Log
    public void annotatedMethod2() {
        System.out.println("----- this.annotatedMethod() 无[annotatedMethod]的增强日志 -----");
        // AOP 失效
        this.annotatedMethod();
        System.out.println("----- ((SubtractService) AopContext.currentProxy()).annotatedMethod() 输出一条[annotatedMethod]的增强日志 -----");
        // AOP 失效 需要配置 @EnableAspectJAutoProxy(exposeProxy = true)
        ((SubtractService) AopContext.currentProxy()).annotatedMethod();
    }
}