package io.walkers.planes.pandora.spring.resource.properties;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertySource;

/**
 * {@link PropertySource} 示例
 *
 * @author Planeswalker23
 */
public class PropertiesSourceByPropertiesTest {

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
