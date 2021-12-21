package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Woman;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 注册 Woman 类
 *
 * @author Planeswalker23
 */
public class WomanImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        registry.registerBeanDefinition("woman", new RootBeanDefinition(Woman.class));
    }
}
