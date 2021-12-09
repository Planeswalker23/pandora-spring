package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 实现 {@link InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class, String)} 的后置处理器
 *
 * @author Planeswalker23
 */
public class UserBeforeInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("拦截原有的实例化方法，使用此处实例" + beanName);
        User user = new User();
        user.setName("postProcessBeforeInstantiation");
        return user;
    }
}
