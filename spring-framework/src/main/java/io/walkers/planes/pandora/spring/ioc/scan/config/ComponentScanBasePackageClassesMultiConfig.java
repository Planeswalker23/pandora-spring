package io.walkers.planes.pandora.spring.ioc.scan.config;

import io.walkers.planes.pandora.spring.ioc.scan.animal.land.Dog;
import io.walkers.planes.pandora.spring.ioc.scan.animal.water.Fish;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 使用 {@link ComponentScan#basePackageClasses()}
 * 指定多个扫描包路径
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(basePackageClasses = {Dog.class, Fish.class})
public class ComponentScanBasePackageClassesMultiConfig {
}
