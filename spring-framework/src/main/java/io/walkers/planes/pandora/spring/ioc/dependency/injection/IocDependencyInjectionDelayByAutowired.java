package io.walkers.planes.pandora.spring.ioc.dependency.injection;

import io.walkers.planes.pandora.spring.ioc.dependency.bean.User;
import io.walkers.planes.pandora.spring.ioc.dependency.bean.UserHolder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * 延迟依赖注入：基于 {@link ObjectProvider} 实现延迟依赖注入
 *
 * @author planeswalker23
 * @date 2021/12/7
 */
public class IocDependencyInjectionDelayByAutowired {

    private User userDelayBySetter;

    private UserHolder userHolderDelayByConstructor;

    @Autowired
    private ObjectProvider<User> userObjectProvider;

    public ObjectProvider<User> getUserObjectProvider() {
        return userObjectProvider;
    }

    @Autowired
    public void setUserDelayBySetter(ObjectProvider<User> userObjectProvider) {
        this.userDelayBySetter = userObjectProvider.getIfAvailable(User::new);
        System.out.println("延迟依赖注入：通过 setter 方法延迟注入");
    }

    @Autowired
    public IocDependencyInjectionDelayByAutowired(ObjectProvider<UserHolder> userHolderObjectProvider) {
        this.userHolderDelayByConstructor = userHolderObjectProvider.getIfAvailable(UserHolder::new);
        System.out.println("延迟依赖注入：通过构造器延迟注入");
    }

    @Bean
    public User userBean() {
        return new User(21, "user21");
    }
}
