package io.walkers.planes.pandora.spring.resource.xml;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertySource;

/**
 * {@link PropertySource} 示例
 *
 * @author Planeswalker23
 */
public class PropertiesSourceByXmlTest {

    @Test
    public void showUserPropertiesByXml() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserXmlConfig.class);
        UserXml userXml = applicationContext.getBean(UserXml.class);
        System.out.println(userXml);

        Assert.assertEquals("PlanesWalker23-Xml", userXml.getName());
        Assert.assertEquals(2, userXml.getId().intValue());
        Assert.assertEquals(20, userXml.getAge().intValue());
    }
}
