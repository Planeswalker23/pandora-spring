package io.walkers.planes.pandora.spring.component.scan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 配置类
 * 使用 {@link ComponentScan#excludeFilters()} 基于类型指定包含的过滤规则
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Configuration
@ComponentScan(
        value = {"io.walkers.planes.pandora.spring.component.scan.animal"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "io.walkers.planes.pandora.spring.component.scan.animal.+Frog.+")
        }
)
public class ComponentScanIncludeFilterByRegexConfig {
}
