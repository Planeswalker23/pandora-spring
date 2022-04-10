package io.walkers.planes.pandora.spring.ioc.dependency;

import io.walkers.planes.pandora.spring.ioc.dependency.spring.Bean;
import io.walkers.planes.pandora.spring.ioc.dependency.spring.ComponentScanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * IOC 依赖注入示例
 *
 * @author Planeswalker23
 */
public class SpringTest {

    @Test
    public void injectionByXmlConfig() {
        // 使用 value 属性作为包扫描路径，将扫描该路径下所有类及子包中的类
        // 仅指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.land 包，期望仅注入 dog
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        Bean bean = applicationContext.getBean(Bean.class);
        System.out.println(bean);
    }
}
