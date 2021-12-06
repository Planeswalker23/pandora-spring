package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注解驱动的依赖注入方式4：方法注入的配置类
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay4MethodHolder {

    private User user;

    public User getUser() {
        return user;
    }

    @Autowired
    public void initUser(User user) {
        this.user = user;
    }
}
