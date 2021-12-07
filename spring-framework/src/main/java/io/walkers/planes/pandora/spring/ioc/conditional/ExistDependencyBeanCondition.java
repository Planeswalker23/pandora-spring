package io.walkers.planes.pandora.spring.ioc.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断容器中是否存在 {@link DependencyBean} 的条件
 *
 * @author Planeswalker23
 * @date 2021/12/7
 */
public class ExistDependencyBeanCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean containsBean = context.getBeanFactory().containsBean("dependencyBean");
        System.out.println("Context contains DependencyBean = " + containsBean);
        return containsBean;
    }
}
