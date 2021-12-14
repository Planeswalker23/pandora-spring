package io.walkers.planes.pandora.spring.ioc.resource.properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类，使用 {@link PropertySource} 导入 user.properties 配置文件
 *
 * @author Planeswalker23
 */
@Configuration
@ComponentScan(basePackageClasses = UserProperties.class)
@PropertySource("META-INF/ioc/resource/user.properties")
public class UserPropertiesConfig {
}
