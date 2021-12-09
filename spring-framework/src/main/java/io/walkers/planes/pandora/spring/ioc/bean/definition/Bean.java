package io.walkers.planes.pandora.spring.ioc.bean.definition;

/**
 * 普通 Bean
 *
 * @author Planeswalker23
 */
public class Bean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                '}';
    }
}
