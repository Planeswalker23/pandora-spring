package io.walkers.planes.pandora.spring.ioc.scan.config;

import io.walkers.planes.pandora.spring.ioc.scan.animal.Frog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 使用 {@link ComponentScan#basePackageClasses()}
 * 指定扫描包路径
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(basePackageClasses = {Frog.class})
public class ComponentScanBasePackageClassesSingleConfig {
}
