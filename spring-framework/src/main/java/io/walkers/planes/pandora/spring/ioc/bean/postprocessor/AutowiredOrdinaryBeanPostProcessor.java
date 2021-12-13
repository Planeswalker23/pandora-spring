package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 注入普通 Bean 的后置处理器
 *
 * @author Planeswalker23
 */
public class AutowiredOrdinaryBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private User user;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前置处理: " + bean);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后置处理: " + bean);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
