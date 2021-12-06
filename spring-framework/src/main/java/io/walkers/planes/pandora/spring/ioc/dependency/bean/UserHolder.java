package io.walkers.planes.pandora.spring.ioc.dependency.bean;

/**
 * 用户组合类
 *
 * @author planeswalker23
 */
public class UserHolder {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
