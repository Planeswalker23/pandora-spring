package io.walkers.planes.pandora.spring.aop.impl;

/**
 * 增强逻辑
 *
 * @author Planeswalker23
 */
public class Logger {

    public void before() {
        System.out.println("增强逻辑...before");
    }

    public void after() {
        System.out.println("增强逻辑...after");
    }

    public void afterReturning() {
        System.out.println("增强逻辑...afterReturning");
    }
}
