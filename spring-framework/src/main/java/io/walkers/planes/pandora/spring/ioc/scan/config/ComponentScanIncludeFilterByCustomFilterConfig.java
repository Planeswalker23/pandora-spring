package io.walkers.planes.pandora.spring.ioc.scan.config;

import io.walkers.planes.pandora.spring.ioc.scan.filter.CustomScanIncludeLandAndWaterFilter;
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
        value = {"io.walkers.planes.pandora.spring.ioc.scan.animal"},
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = CustomScanIncludeLandAndWaterFilter.class)
        }
)
public class ComponentScanIncludeFilterByCustomFilterConfig {
}
