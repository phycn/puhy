package cn.puhy.spring.ioc.test;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.puhy.spring.ioc.lifecycle.LifecycleCar;
import cn.puhy.spring.ioc.lifecycle.MyInstantiationAwareBeanPostProcessor;

public class BeanLifeCycleTest {
	
	@Test
	public void test() {
		
		//加载配置文件并启动容器
		Resource rs = new ClassPathResource("cn/puhy/spring/ioc/lifecycle-context.xml");
		ConfigurableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
		reader.loadBeanDefinitions(rs);
		
		//向容器中注册后处理器
		bf.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		//第一次从容器中获取bean,引发bean的生命周期
		LifecycleCar car1 = (LifecycleCar)bf.getBean(LifecycleCar.class);
		System.out.println(car1);
		car1.setColor("银色");
		
		LifecycleCar car2 = (LifecycleCar)bf.getBean(LifecycleCar.class);
		System.out.println(car1);
		
		System.out.println(car1 == car2);
		bf.destroySingletons();
	}
}
