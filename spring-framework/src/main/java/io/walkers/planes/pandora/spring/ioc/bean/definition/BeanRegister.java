package io.walkers.planes.pandora.spring.ioc.bean.definition;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * {@link Bean} 注册器
 *
 * @author Planeswalker23
 */
public class BeanRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        // 声明 BeanDefinition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
                .genericBeanDefinition(Bean.class)
                .addPropertyValue("name", "beanName");

        // 注册 BeanDefinition
        registry.registerBeanDefinition("bean", beanDefinitionBuilder.getBeanDefinition());
    }
}
