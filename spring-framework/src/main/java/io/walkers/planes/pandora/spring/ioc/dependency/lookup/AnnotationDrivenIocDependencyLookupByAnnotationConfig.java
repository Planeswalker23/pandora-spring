package io.walkers.planes.pandora.spring.ioc.dependency.lookup;

import io.walkers.planes.pandora.spring.ioc.dependency.annotation.Person;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.context.annotation.Bean;

/**
 * 注解驱动的根据注解进行依赖查找的配置类
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyLookupByAnnotationConfig {

    @Bean
    @Person
    public User user() {
        User user = new User();
        user.setId(4);
        user.setName("PlanesWalker23-lookup-byAnnotation");
        return user;
    }
}
