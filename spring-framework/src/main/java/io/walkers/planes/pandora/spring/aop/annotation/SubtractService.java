package io.walkers.planes.pandora.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * 自减-1
 *
 * @author Planeswalker23
 */
@Component
public class SubtractService {

    public int subtractOne(int source) {
        System.out.println("SubtractService#subtractOne...source = " + source);
        source -= 1;
        return source;
    }

    public int exception() {
        System.out.println("SubtractService#exception");
        return 1 / 0;
    }

    @Log
    public void annotatedMethod() {
        System.out.println("SubtractService#annotatedMethod");
    }
}