package io.walkers.planes.pandora.spring.component.scan.config;

import io.walkers.planes.pandora.spring.component.scan.annotation.Land;
import io.walkers.planes.pandora.spring.component.scan.annotation.Sky;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 * 使用 {@link ComponentScan#includeFilters()} 基于注解指定包含的过滤规则
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(
        value = {"io.walkers.planes.pandora.spring.component.scan.animal"},
        // 不使用默认过滤器(即 @Component @Repository, @Service, @Controller 注解)
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Land.class),
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Sky.class)
        }
)
public class ComponentScanIncludeFilterByAnnotationConfig {
}
