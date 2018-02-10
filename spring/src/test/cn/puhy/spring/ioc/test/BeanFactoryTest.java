package cn.puhy.spring.ioc.test;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import cn.puhy.spring.ioc.Car;

public class BeanFactoryTest {
	
	@Test
	public void getBean() throws IOException {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("cn/puhy/spring/ioc/ioc-context.xml");
		
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//装载并启动ioc容器
		reader.loadBeanDefinitions(res);
		
		Car car = factory.getBean("car1", Car.class);
		
		System.out.println(car);
	}
}
