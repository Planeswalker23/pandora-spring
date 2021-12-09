package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 自定义 {@link BeanFactoryPostProcessor} 后置处理器
 *
 * @author Planeswalker23
 */
public class UserBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");
        System.out.println("BeanDefinition of user scope = " + beanDefinition.getScope());
        // 将 User 的作用域改为原型
        beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}
