package io.walkers.planes.pandora.spring.ioc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

/**
 * {@link PayloadApplicationEvent} 事件监听器，只监听 payload 为 Integer 类型的事件
 *
 * @author Planeswalker23
 */
public class IntegerPayloadEventApplicationListener implements ApplicationListener<PayloadApplicationEvent<Integer>> {
    @Override
    public void onApplicationEvent(PayloadApplicationEvent event) {
        System.out.println("监听到 PayloadApplicationEvent 事件，Integer 值为：" + event.getPayload());
    }
}
