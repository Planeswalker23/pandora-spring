package io.walkers.planes.pandora.spring.resource.xml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户配置类
 *
 * @author Planeswalker23
 */
@Component
public class UserXml {

    @Value("${id:2}")
    private Long id;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;

    @Override
    public String toString() {
        return "UserProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
