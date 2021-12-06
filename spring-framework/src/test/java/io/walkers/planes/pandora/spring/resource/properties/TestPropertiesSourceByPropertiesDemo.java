package io.walkers.planes.pandora.spring.resource.properties;

import io.walkers.planes.pandora.spring.resource.properties.UserProperties;
import io.walkers.planes.pandora.spring.resource.properties.UserPropertiesConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertySource;

/**
 * {@link PropertySource} 示例
 *
 * @author 范逸东(东稚)
 */
public class TestPropertiesSourceByPropertiesDemo {

    @Test
    public void showUserPropertiesByProperties() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserPropertiesConfig.class);
        UserProperties userProperties = applicationContext.getBean(UserProperties.class);
        System.out.println(userProperties);

        Assert.assertEquals("PlanesWalker23", userProperties.getName());
        Assert.assertEquals(1, userProperties.getId().intValue());
        Assert.assertEquals(18, userProperties.getAge().intValue());
    }
}
