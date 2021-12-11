package io.walkers.planes.pandora.spring.ioc.event;

import org.junit.Test;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link PayloadApplicationEvent} 使用示例
 *
 * @author Planeswalker23
 */
public class PayloadEventApplicationListenerTest {

    @Test
    public void payload() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.addApplicationListener(new IntegerPayloadEventApplicationListener());
        applicationContext.addApplicationListener(new StringPayloadEventApplicationListener());
        applicationContext.addApplicationListener(new ObjectPayloadEventApplicationListener());
        applicationContext.refresh();

        applicationContext.publishEvent(233);
        applicationContext.publishEvent("hello, world");
        applicationContext.publishEvent(new PayloadEventApplicationListenerTest());

        applicationContext.close();
    }
}
