package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Woman;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于启动模块装配的注解
 * <p>
 * 使用 {@link Import} 导入 {@link Woman} 类
 *
 * @author Planeswalker23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(WomanImportBeanDefinitionRegistrar.class)
public @interface EnableWiringImportWoman {
}
