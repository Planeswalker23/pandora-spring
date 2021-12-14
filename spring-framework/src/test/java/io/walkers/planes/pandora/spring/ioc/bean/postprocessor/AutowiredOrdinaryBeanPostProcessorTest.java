package io.walkers.planes.pandora.spring.ioc.bean.postprocessor;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 注入普通 Bean 的 {@link BeanPostProcessor} 示例
 *
 * @author Planeswalker23
 */
public class AutowiredOrdinaryBeanPostProcessorTest {

    @Test
    public void custom() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getBeanFactory().addBeanPostProcessor(new AutowiredOrdinaryBeanPostProcessor());
        applicationContext.register(AutowiredOrdinaryBeanPostProcessor.class);
        applicationContext.register(User.class);
        applicationContext.refresh();
        applicationContext.close();
        // 存在日志：信息: Bean 'user' of type [io.walkers.planes.pandora.spring.ioc.bean.postprocessor.User] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
        // 该日志意味着 BeanPostProcessor 中有注入普通 Bean（该 Bean 被提前创建，未经历其他 BeanPostProcessor 处理，是不完全的），需要给代码作出调整
    }
}
