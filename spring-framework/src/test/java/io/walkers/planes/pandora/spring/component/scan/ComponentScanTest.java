package io.walkers.planes.pandora.spring.component.scan;

import io.walkers.planes.pandora.spring.component.scan.config.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

/**
 * {@link ComponentScan} 使用示例
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
public class ComponentScanTest {

    @Test
    public void valueSingleConfig() {
        // 使用 value 属性作为包扫描路径，将扫描该路径下所有类及子包中的类
        // 仅指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.land 包，期望仅注入 dog
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanValueSingleConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertFalse(beanNames.contains("bird"));
        Assert.assertFalse(beanNames.contains("fish"));
        Assert.assertFalse(beanNames.contains("frog"));
    }

    @Test
    public void valueMultiConfig() {
        // 使用 value 属性作为包扫描路径，将扫描该路径下所有类及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.land 和 io.walkers.planes.pandora.spring.component.scan.animal.sky 包
        // 期望注入 dog 和 bird
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanValueMultiConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertTrue(beanNames.contains("bird"));
        Assert.assertFalse(beanNames.contains("fish"));
        Assert.assertFalse(beanNames.contains("frog"));
    }

    @Test
    public void basePackageClassesSingleConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 类为 Frog 时，期望注入 dog, bird, fish, frog
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBasePackageClassesSingleConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertTrue(beanNames.contains("bird"));
        Assert.assertTrue(beanNames.contains("fish"));
        Assert.assertTrue(beanNames.contains("frog"));
    }

    @Test
    public void basePackageClassesMultiConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 类为 Frog 时，期望注入 dog, bird, fish, frog
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanBasePackageClassesMultiConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertFalse(beanNames.contains("bird"));
        Assert.assertTrue(beanNames.contains("fish"));
        Assert.assertFalse(beanNames.contains("frog"));
    }

    @Test
    public void includeFilterByAnnotationConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.water 包下包含 @Sky 和 @Land 注解
        // 期望注入 dog, bird, frog, frogNotComponent
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanIncludeFilterByAnnotationConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertTrue(beanNames.contains("bird"));
        Assert.assertFalse(beanNames.contains("fish"));
        Assert.assertTrue(beanNames.contains("frog"));
        // 测试 useDefaultFilters = false
        Assert.assertTrue(beanNames.contains("frogNotComponent"));
    }

    @Test
    public void excludeFilterByAnnotationConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.water 包下不包含 @Sky 和 @Land 注解
        // 期望注入 fish
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanExcludeFilterByAnnotationConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertFalse(beanNames.contains("dog"));
        Assert.assertFalse(beanNames.contains("bird"));
        Assert.assertTrue(beanNames.contains("fish"));
        Assert.assertFalse(beanNames.contains("frog"));
    }

    @Test
    public void excludeFilterByTypeConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.water 包下不包含 Dog 类的注入 Bean
        // 期望不注入 Dog
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanExcludeFilterByTypeConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertFalse(beanNames.contains("dog"));
        Assert.assertTrue(beanNames.contains("bird"));
        Assert.assertTrue(beanNames.contains("fish"));
        Assert.assertTrue(beanNames.contains("frog"));
    }

    @Test
    public void includeFilterByRegexConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.water 包下包含 NotComponent 名称的 Bean
        // 期望注入 frogNotComponent
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanIncludeFilterByRegexConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertTrue(beanNames.contains("dog"));
        Assert.assertTrue(beanNames.contains("bird"));
        Assert.assertTrue(beanNames.contains("fish"));
        Assert.assertTrue(beanNames.contains("frog"));
        Assert.assertTrue(beanNames.contains("frogNotComponent"));
    }

    @Test
    public void includeFilterByCustomConfig() {
        // 使用 basePackageClasses 属性作为包扫描路径，将扫描该类所在包路径下及子包中的类
        // 指定扫描 io.walkers.planes.pandora.spring.component.scan.animal.water 包下包含 @Land 和 @Sky 名称的 Bean
        // 期望注入 frog, frogNotComponent
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanIncludeFilterByCustomFilterConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        List<String> beanNames = Arrays.asList(beanDefinitionNames);
        beanNames.forEach(System.out::println);
        Assert.assertFalse(beanNames.contains("dog"));
        Assert.assertFalse(beanNames.contains("bird"));
        Assert.assertFalse(beanNames.contains("fish"));
        Assert.assertTrue(beanNames.contains("frog"));
        Assert.assertTrue(beanNames.contains("frogNotComponent"));
    }
}
