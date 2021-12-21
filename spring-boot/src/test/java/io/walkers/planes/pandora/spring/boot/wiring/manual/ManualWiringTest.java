package io.walkers.planes.pandora.spring.boot.wiring.manual;

import io.walkers.planes.pandora.spring.boot.wiring.bean.Child;
import io.walkers.planes.pandora.spring.boot.wiring.bean.Dog;
import io.walkers.planes.pandora.spring.boot.wiring.bean.Man;
import io.walkers.planes.pandora.spring.boot.wiring.bean.Woman;
import io.walkers.planes.pandora.spring.boot.wiring.manual.config.ConfigImportChild;
import io.walkers.planes.pandora.spring.boot.wiring.manual.config.ConfigImportDog;
import io.walkers.planes.pandora.spring.boot.wiring.manual.config.ConfigImportMan;
import io.walkers.planes.pandora.spring.boot.wiring.manual.config.ConfigImportWoman;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * 手动装配单元测试
 *
 * @author Planeswalker23
 */
public class ManualWiringTest {

    @Test
    public void child() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigImportChild.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanDefinitionNameList = Arrays.asList(beanDefinitionNames);

        Assert.assertTrue(beanDefinitionNameList.contains(Child.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Dog.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Man.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Woman.class.getName()));
    }

    @Test
    public void dog() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigImportDog.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanDefinitionNameList = Arrays.asList(beanDefinitionNames);

        Assert.assertFalse(beanDefinitionNameList.contains(Child.class.getName()));
        Assert.assertTrue(beanDefinitionNameList.contains("dog"));
        Assert.assertFalse(beanDefinitionNameList.contains(Man.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Woman.class.getName()));
    }

    @Test
    public void man() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigImportMan.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanDefinitionNameList = Arrays.asList(beanDefinitionNames);

        Assert.assertFalse(beanDefinitionNameList.contains(Child.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Dog.class.getName()));
        Assert.assertTrue(beanDefinitionNameList.contains(Man.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Woman.class.getName()));
    }

    @Test
    public void woman() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigImportWoman.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanDefinitionNameList = Arrays.asList(beanDefinitionNames);

        Assert.assertFalse(beanDefinitionNameList.contains(Child.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Dog.class.getName()));
        Assert.assertFalse(beanDefinitionNameList.contains(Man.class.getName()));
        Assert.assertTrue(beanDefinitionNameList.contains("woman"));
    }
}
