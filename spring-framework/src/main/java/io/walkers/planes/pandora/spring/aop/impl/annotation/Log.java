package io.walkers.planes.pandora.spring.aop.impl.annotation;

import java.lang.annotation.*;

/**
 * 自定义切入注解
 *
 * @author Planeswalker23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}
