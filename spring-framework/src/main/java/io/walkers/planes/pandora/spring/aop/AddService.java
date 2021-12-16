package io.walkers.planes.pandora.spring.aop;

/**
 * 自增+1
 *
 * @author Planeswalker23
 */
public class AddService {

    public int plusOne(int source) {
        System.out.println("AddService#plusOne...source = " + source);
        source += 1;
        return source;
    }
}
