package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Man;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 注册 Man 类
 *
 * @author Planeswalker23
 */
public class ManSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Man.class.getName()};
    }
}
