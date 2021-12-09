package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 实现 {@link InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation(Object, String)} 的后置处理器
 *
 * @author Planeswalker23
 */
public class UserAfterInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAssignableFrom(User.class)) {
            // true: 会执行 InstantiationAwareBeanPostProcessor#postProcessProperties 方法
            return true;
        } else {
            System.out.println("beanName = " + beanName);
            return false;
        }
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("name", "postProcessProperties");
        return propertyValues;
    }
}
