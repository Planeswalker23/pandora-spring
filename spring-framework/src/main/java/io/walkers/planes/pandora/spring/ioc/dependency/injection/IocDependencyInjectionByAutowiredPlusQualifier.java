package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * 自动注入：基于 {@link Autowired} + {@link Qualifier} 注解进行限定注入(分组注入)
 * <p>
 * 匹配原理：先匹配类型，若存在多个相同类型的 Bean，再根据名称匹配，
 * 若有 {@link Primary} 注解标注的同类型 Bean，返回该 Bean
 * 若存在一个名称匹配成功，直接返回
 * 若不存在相同名称的 Bean，抛出 NoUniqueBeanDefinitionException
 *
 * @author planeswalker23
 * @date 2021/12/7
 */
public class IocDependencyInjectionByAutowiredPlusQualifier {

    @Autowired
    private User autowiredUser;
    @Autowired
    private List<User> autowiredUsers;
    @Autowired
    @Qualifier
    private List<User> qualifierUsers;
    @Autowired
    @Qualifier("custom")
    private List<User> qualifierCustomUsers;

    @Bean
    @Primary
    public User user1() {
        return new User(14, "user14");
    }

    @Bean
    @Qualifier("custom")
    public User user2() {
        return new User(15, "customUser");
    }

    @Bean
    @Qualifier
    public User user3() {
        return new User(16, "user16");
    }

    public User getAutowiredUser() {
        return autowiredUser;
    }

    public List<User> getAutowiredUsers() {
        return autowiredUsers;
    }

    public List<User> getQualifierUsers() {
        return qualifierUsers;
    }

    public List<User> getQualifierCustomUsers() {
        return qualifierCustomUsers;
    }
}
