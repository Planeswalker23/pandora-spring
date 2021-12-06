package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注解驱动的依赖注入方式3：字段注入的配置类
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay3FieldHolder {

    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
