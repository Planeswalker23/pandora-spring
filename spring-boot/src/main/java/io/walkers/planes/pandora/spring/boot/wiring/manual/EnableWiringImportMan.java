package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Man;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 用于启动模块装配的注解
 * <p>
 * 使用 {@link Import} 导入 {@link Man} 类
 *
 * @author Planeswalker23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ManSelector.class)
public @interface EnableWiringImportMan {
}
