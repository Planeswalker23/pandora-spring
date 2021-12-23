package io.walkers.planes.pandora.spring.aop.disable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用于演示 [调用 private 方法] 的 AOP 失效场景的业务
 *
 * @author Planeswalker23
 */
@Component
public class AopDisableInvokePrivateMethod {

    @Autowired
    private AopDisableInvokePrivateMethod aopDisableInvokePrivateMethod;

    // private 访问权限
    private void processOne() {
        System.out.println("AopDisableProcessor#processOne 执行.");
    }

    public void processTwoEnableAopByInjectMyself() {
        System.out.println("AopDisableProcessor#processTwoEnableAopByInjectMyself 执行.");
        aopDisableInvokePrivateMethod.processOne();
    }
}
