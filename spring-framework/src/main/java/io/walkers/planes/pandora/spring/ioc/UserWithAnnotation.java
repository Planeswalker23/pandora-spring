package io.walkers.planes.pandora.spring.ioc;

import io.walkers.planes.pandora.spring.ioc.annotation.User;

/**
 * 用户类
 *
 * @author Planeswalker23
 */
@User
public class UserWithAnnotation {

    private Integer id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
