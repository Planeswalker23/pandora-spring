package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Dog;
import io.walkers.planes.pandora.spring.boot.wiring.manual.config.ConfigWithBeanDog;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于启动模块装配的注解
 * <p>
 * 使用 {@link Import} 导入 {@link Dog} 类
 *
 * @author Planeswalker23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ConfigWithBeanDog.class)
public @interface EnableWiringImportDog {
}
