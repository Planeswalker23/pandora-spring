package io.walkers.planes.pandora.spring.ioc.bean.lifecycle;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 生命周期
 *
 * @author Planeswalker23
 * @date 2021/12/7
 */
public class IocBeanLifecycleTest {

    @Test
    public void normalLifecycle() throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 BeanPostProcessor
        applicationContext.getBeanFactory().addBeanPostProcessor(new LifecycleBeanBeanPostProcessor());
        applicationContext.getBeanFactory().addBeanPostProcessor(new LifecycleBeanInstantiationAwareBeanPostProcessor());
        applicationContext.getBeanFactory().addBeanPostProcessor(new LifecycleBeanDestructionAwareBeanPostProcessor());

        // 注册 BeanDefinition
        // 使用 @Bean 声明 lifecycleBean 对象时 CustomInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation 未生效
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(LifecycleBean.class);
        beanDefinitionBuilder.addPropertyValue("name", "生命周期");

        // 初始化阶段：指定自定义初始化方法
        beanDefinitionBuilder.setInitMethodName("initMethod");
        beanDefinitionBuilder.setDestroyMethodName("destroyMethod");
        applicationContext.registerBeanDefinition("lifecycleBean", beanDefinitionBuilder.getBeanDefinition());

        applicationContext.register(IocBeanLifecycleTest.class);
        System.out.println("Spring 容器准备启动");
        applicationContext.refresh();
        System.out.println("Spring 容器启动完成");

        LifecycleBean lifecycleBean = applicationContext.getBean(LifecycleBean.class);
        System.out.println("依赖查询 lifecycleBean 类型对象结果：" + lifecycleBean);

        System.out.println("Spring 容器准备关闭");
        applicationContext.close();
        System.out.println("Spring 容器关闭完成");

        // 辅助垃圾回收
        lifecycleBean = null;
        // 强制触发 GC
        System.gc();
        Thread.sleep(1000L);
    }

    @Test
    public void destroy() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 BeanDefinition
        // 使用 @Bean 声明 lifecycleBean 对象时 CustomInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation 未生效
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(LifecycleBean.class);
        beanDefinitionBuilder.addPropertyValue("name", "生命周期");

        // 初始化阶段：指定自定义初始化方法
        beanDefinitionBuilder.setInitMethodName("initMethod");
        beanDefinitionBuilder.setDestroyMethodName("destroyMethod");
        applicationContext.registerBeanDefinition("lifecycleBean", beanDefinitionBuilder.getBeanDefinition());

        applicationContext.register(IocBeanLifecycleTest.class);

        System.out.println("Spring 容器准备启动");
        applicationContext.refresh();
        System.out.println("Spring 容器启动完成");

        LifecycleBean lifecycleBean = applicationContext.getBean(LifecycleBean.class);
        System.out.println("依赖查询 lifecycleBean 类型对象结果：" + lifecycleBean);

        // 为什么此处没有触发自定义销毁方法？
        // org.springframework.beans.factory.config.AutowireCapableBeanFactory.destroyBean 在创建 DisposableBeanAdapter 对象时不会基于 RootBeanDefinition 指定自定义销毁方法
        System.out.println("开始基于 AutowireCapableBeanFactory#destroyBean(Object existingBean) 触发 lifecycleBean 对象的销毁生命周期");
        applicationContext.getBeanFactory().destroyBean(lifecycleBean);
        System.out.println("基于 AutowireCapableBeanFactory#destroyBean(Object existingBean) 触发 lifecycleBean 对象的销毁生命周期完成");

        // org.springframework.beans.factory.config.ConfigurableBeanFactory.destroyBean 在创建 DisposableBeanAdapter 对象时会基于 RootBeanDefinition 指定自定义销毁方法
        System.out.println("开始基于 ConfigurableBeanFactory#destroyBean(String beanName, Object beanInstance) 触发 lifecycleBean 对象的销毁生命周期");
        applicationContext.getBeanFactory().destroyBean("lifecycleBean", lifecycleBean);
        System.out.println("基于 ConfigurableBeanFactory#destroyBean(String beanName, Object beanInstance) 触发 lifecycleBean 对象的销毁生命周期完成");

        System.out.println("Spring 容器准备关闭");
        applicationContext.close();
        System.out.println("Spring 容器关闭完成");
    }
}
