package io.walkers.planes.pandora.spring.ioc.config;

import io.walkers.planes.pandora.spring.ioc.User;
import org.springframework.context.annotation.Bean;

/**
 * 注解驱动的依赖查找配置类
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyLookupConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(6);
        user.setName("PlanesWalker23-annotation-drive");
        return user;
    }
}
