package io.walkers.planes.pandora.spring.resource.xml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类，使用 {@link PropertySource} 导入 user.xml 配置文件
 *
 * @author 范逸东(东稚)
 */
@Configuration
@ComponentScan(basePackageClasses = UserXml.class)
@PropertySource("META-INF/resource/user.xml")
public class UserXmlConfig {
}
