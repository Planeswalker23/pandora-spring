package io.walkers.planes.pandora.spring.boot.wiring.manual.config;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 *
 * @author Planeswalker23
 */
@Configuration
public class ConfigWithBeanDog {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
