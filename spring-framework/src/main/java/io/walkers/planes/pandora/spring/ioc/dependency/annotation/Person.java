package io.walkers.planes.pandora.spring.ioc.dependency.annotation;

import java.lang.annotation.*;

/**
 * 给用户的注解
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Person {
}
