package io.walkers.planes.pandora.spring.aop.impl;

/**
 * 用户 Service 接口实现类
 *
 * @author Planeswalker23
 */
public class OneServiceImpl implements OneService {

    @Override
    public int doAdd(int source) {
        System.out.println("AddServiceImpl#addOne...source = " + source);
        source++;
        return source;
    }
}
