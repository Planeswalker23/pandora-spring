package io.walkers.planes.pandora.spring.aop.disable;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * 用于演示 [通过 this 调用自己方法] 的 AOP 失效场景的业务
 *
 * @author Planeswalker23
 */
@Component
public class AopDisableInvokeMyselfProcessor {

    private AopDisableInvokeMyselfProcessor aopDisableInvokeMyselfProcessor;

    public void processOne() {
        System.out.println("AopDisableProcessor#processOne 执行.");
    }

    public void processTwo() {
        System.out.println("AopDisableProcessor#processTwo 执行.");
        processOne();
    }

    public void processTwoEnableAopByAopContext() {
        System.out.println("AopDisableProcessor#processTwoEnableAopByAopContext 执行.");
        ((AopDisableInvokeMyselfProcessor) AopContext.currentProxy()).processOne();
    }

    public void processTwoEnableAopByInjectMyself() {
        System.out.println("AopDisableProcessor#processTwoEnableAopByInjectMyself 执行.");
        ((AopDisableInvokeMyselfProcessor) AopContext.currentProxy()).processOne();
    }
}
