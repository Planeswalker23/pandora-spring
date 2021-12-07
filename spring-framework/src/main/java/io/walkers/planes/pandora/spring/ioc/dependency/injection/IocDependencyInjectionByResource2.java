package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 自动注入：基于 {@link Resource} 注解实现注入的逻辑，Bean 相同名称相同类型
 *
 * @author planeswalker23
 * @date 2021/12/7
 */
public class IocDependencyInjectionByResource2 {

    @Resource
    private User userBean;

    @Bean
    public User userBean() {
        return new User(18, "userBean");
    }

    public User getUserBean() {
        return userBean;
    }
}
