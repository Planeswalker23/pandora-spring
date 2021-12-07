package io.walkers.planes.pandora.spring.ioc.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，Condition 判断结果为 true
 *
 * @author planeswalker23
 * @date 2021/12/7
 */
@Configuration
public class ConditionalTrueConfig {

    @Bean
    public DependencyBean dependencyBean() {
        return new DependencyBean();
    }

    @Bean
    @Conditional(ExistDependencyBeanCondition.class)
    public ConditionBean conditionBean() {
        return new ConditionBean();
    }
}
