package io.walkers.planes.pandora.spring.ioc.dependency.spring;

import org.springframework.stereotype.Service;

/**
 * @author planeswalker23
 * @date 2022/4/10
 */
@Service
public class Bean {

    private DemoInterface demoInterfaceImpl2;

    public Bean(DemoInterface demoInterfaceImpl2) {
        this.demoInterfaceImpl2 = demoInterfaceImpl2;
    }
}
