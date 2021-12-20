package io.walkers.planes.pandora.spring.aop.disable;

import org.springframework.stereotype.Component;

/**
 * 用于演示 [提前加载 Bean] 的 AOP 失效场景的业务
 *
 * @author Planeswalker23
 */
@Component
public class AopDisableLoadBeanAdvanceProcessor {

    public void processOne() {
        System.out.println("AopDisableProcessor#processOne 执行.");
    }
}
