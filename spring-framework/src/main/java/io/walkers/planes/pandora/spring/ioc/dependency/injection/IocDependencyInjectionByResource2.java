package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 自动注入：基于 {@link Resource} 注解实现注入的逻辑，Bean 相同名称相同类型
 * <p>
 * 匹配原理：根据名称进行匹配，若类型不同抛出异常 {@link BeanCreationException} BeanNotOfRequiredTypeException
 * 若类型相同则匹配成功
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

    @Bean
    public User userBean1() {
        return new User(19, "userBean19");
    }

    public User getUserBean() {
        return userBean;
    }
}
