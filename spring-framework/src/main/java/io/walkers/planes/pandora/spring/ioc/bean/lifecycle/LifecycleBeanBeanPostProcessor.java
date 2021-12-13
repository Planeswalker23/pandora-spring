package io.walkers.planes.pandora.spring.ioc.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Spring Bean 初始化后置处理器
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class LifecycleBeanBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (LifecycleBean.class.isAssignableFrom(bean.getClass())) {
            System.out.println("LifecycleBean 对象初始化前置处理 【BeanPostProcessor#postProcessBeforeInitialization】");
            ((LifecycleBean) bean).setName("初始化前置处理");
        }
        // 可返回新的对象
//        return new LifecycleBean();
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化后置处理
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (LifecycleBean.class.isAssignableFrom(bean.getClass())) {
            System.out.println("LifecycleBean 对象初始化后置处理 【BeanPostProcessor#postProcessAfterInitialization】");
            ((LifecycleBean) bean).setName("初始化后置处理");
        }
        // 可返回新的对象
//        return new LifecycleBean();
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
