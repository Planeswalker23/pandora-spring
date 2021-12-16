package io.walkers.planes.pandora.spring.aop;

/**
 * AOP 的增强逻辑
 *
 * @author Planeswalker23
 */
public class Logger {

    public void before() {
        System.out.println("日志增强逻辑...before");
    }

    public void after() {
        System.out.println("日志增强逻辑...after");
    }
}
