package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注解驱动的依赖注入方式2：构造器注入的配置类
 *
 * @author Planeswalker23
 */
public class IocDependencyInjectionWay2ConstructorHolder {

    private User user;

    @Autowired
    public IocDependencyInjectionWay2ConstructorHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
