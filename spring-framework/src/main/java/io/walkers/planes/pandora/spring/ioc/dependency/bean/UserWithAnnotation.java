package io.walkers.planes.pandora.spring.ioc.dependency.bean;

import io.walkers.planes.pandora.spring.ioc.dependency.annotation.Person;

/**
 * 用户类
 *
 * @author Planeswalker23
 */
@Person
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
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
