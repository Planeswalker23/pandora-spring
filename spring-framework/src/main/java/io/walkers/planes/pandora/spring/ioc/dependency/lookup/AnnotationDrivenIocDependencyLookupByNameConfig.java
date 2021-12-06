package io.walkers.planes.pandora.spring.ioc.dependency.lookup;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.context.annotation.Bean;

/**
 * 注解驱动的根据名称进行依赖查找的配置类
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyLookupByNameConfig {

    @Bean("userLookupByName")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("PlanesWalker23-lookup-byName");
        return user;
    }
}
