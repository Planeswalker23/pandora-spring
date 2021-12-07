package io.walkers.planes.pandora.spring.ioc.scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 使用 {@link ComponentScan#value()}
 * 以及 {@link ComponentScan#basePackages()}
 * 指定扫描包路径
 * 仅指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.land 包，期望仅注入 dog
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(value = {"io.walkers.planes.pandora.spring.ioc.scan.animal.land"})
public class ComponentScanValueSingleConfig {
}
