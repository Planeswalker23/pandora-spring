package io.walkers.planes.pandora.spring.aop.impl.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 基于 AspectJ 注解实现 AOP 的配置类
 *
 * @author Planeswalker23
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("io.walkers.planes.pandora.spring.aop.impl.annotation")
public class AnnotationAopConfig {
}
