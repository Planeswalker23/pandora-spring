package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.inject.Inject;

/**
 * 自动注入：基于 {@link Inject} 注解实现注入的逻辑，与 {@link Autowired} 功能一致
 *
 * @author planeswalker23
 * @date 2021/12/7
 * @see IocDependencyInjectionByAutowiredPlusQualifier
 */
public class IocDependencyInjectionByInject {

    @Inject
    private User user;

    @Bean
    public User userBean() {
        return new User(20, "user20");
    }

    public User getUser() {
        return user;
    }
}
