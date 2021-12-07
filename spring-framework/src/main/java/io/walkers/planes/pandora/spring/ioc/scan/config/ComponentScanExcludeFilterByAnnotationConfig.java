package io.walkers.planes.pandora.spring.ioc.scan.config;

import io.walkers.planes.pandora.spring.ioc.scan.annotation.Land;
import io.walkers.planes.pandora.spring.ioc.scan.annotation.Sky;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 * 使用 {@link ComponentScan#excludeFilters()} 基于注解指定排除的过滤规则
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(
        value = {"io.walkers.planes.pandora.spring.ioc.scan.animal"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Land.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Sky.class)
        }
)
public class ComponentScanExcludeFilterByAnnotationConfig {
}
