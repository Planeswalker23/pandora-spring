package io.walkers.planes.pandora.spring.ioc.dependency.lookup;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.context.annotation.Bean;

/**
 * 注解驱动的根据类型进行延迟依赖查找的配置类
 *
 * @author Planeswalker23
 */
public class AnnotationDrivenIocDependencyLookupDelayByTypeConfig {

    @Bean
    public User user() {
        User user = new User();
        user.setId(5);
        user.setName("PlanesWalker23-delay-lookup-byType");
        return user;
    }
}
