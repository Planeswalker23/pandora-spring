package io.walkers.planes.pandora.spring.component.scan.annotation;

import java.lang.annotation.*;

/**
 * 给陆地动物的注解
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Land {
}
