package io.walkers.planes.pandora.spring.ioc.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * Spring Bean 销毁前置处理器
 *
 * @author planeswalker23
 * @date 2021/11/22
 */
public class LifecycleBeanDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (LifecycleBean.class.isAssignableFrom(bean.getClass())) {
            System.out.println("LifecycleBean 对象销毁前置阶段");
        }
    }
}
