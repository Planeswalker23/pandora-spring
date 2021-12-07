package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserHolder;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 自动注入：基于 {@link Resource} 注解实现注入的逻辑，Bean 相同名称不同类型
 *
 * @author planeswalker23
 * @date 2021/12/7
 */
public class IocDependencyInjectionByResource {

    @Resource
    private UserHolder user;

    @Bean
    public User user() {
        return new User(17, "user17");
    }

    @Bean("user")
    public UserHolder userHolder() {
        return new UserHolder();
    }
}
