package io.walkers.planes.pandora.spring.aop.disable.beanpostprocessor;

import io.walkers.planes.pandora.spring.aop.disable.AopDisableLoadBeanAdvanceProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 用于演示 [提前加载 Bean] 的 AOP 失效场景的 BeanPostProcessor
 *
 * @author Planeswalker23
 */
@Component
@Order
public class AopDisableBeanProcessor implements BeanPostProcessor {

    /**
     * BeanPostProcessor 中不应进行依赖注入，会导致 Bean 提前加载导致 AOP 失效
     */
    @Autowired
    private AopDisableLoadBeanAdvanceProcessor aopDisableLoadBeanAdvanceProcessor;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
