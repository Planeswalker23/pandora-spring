package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserHolder;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 自动注入：基于 {@link Resource} 注解实现注入的逻辑，Bean 相同名称不同类型
 * <p>
 * 匹配原理：根据名称进行匹配，若类型不同抛出异常 {@link BeanCreationException} BeanNotOfRequiredTypeException
 * 若类型相同则匹配成功
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
}
