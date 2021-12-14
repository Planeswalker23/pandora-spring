package io.walkers.planes.pandora.spring.aop.impl;

/**
 * 普通类
 *
 * @author Planeswalker23
 */
public class TwoService {

    public int doAdd(int source) {
        System.out.println("AddTwoService#doAdd...source = " + source);
        source += 2;
        return source;
    }
}
