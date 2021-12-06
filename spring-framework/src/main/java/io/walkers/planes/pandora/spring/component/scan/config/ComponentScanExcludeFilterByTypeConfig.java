package io.walkers.planes.pandora.spring.component.scan.config;

import io.walkers.planes.pandora.spring.component.scan.animal.land.Dog;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 * 使用 {@link ComponentScan#excludeFilters()} 基于类型指定排除的过滤规则
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(
        value = {"io.walkers.planes.pandora.spring.component.scan.animal"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Dog.class)
        }
)
public class ComponentScanExcludeFilterByTypeConfig {
}
