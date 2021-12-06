package io.walkers.planes.pandora.spring.resource.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户配置类
 *
 * @author 范逸东(东稚)
 */
@Component
public class UserProperties {

    @Value("${id:1}")
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
