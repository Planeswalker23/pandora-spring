package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 注解驱动的依赖注入的配置类
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyInjectionConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(3);
        user.setName("PlanesWalker23-injection");
        return user;
    }

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }
}
