package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建 User 类的工厂 Bean
 *
 * @author Planeswalker23
 */
public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setName("UserFactoryBean");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
