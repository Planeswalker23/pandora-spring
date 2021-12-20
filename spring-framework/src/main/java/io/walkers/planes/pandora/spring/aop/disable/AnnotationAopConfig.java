package io.walkers.planes.pandora.spring.aop.disable;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 基于 AspectJ 注解实现 AOP 的配置类
 *
 * @author Planeswalker23
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@ComponentScan("io.walkers.planes.pandora.spring.aop.disable")
public class AnnotationAopConfig {
}
