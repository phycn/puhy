package cn.puhy.spring.inject.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.inject.property.Bean1;

public class PropertyInjectTest {
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/inject/property-context.xml");
		Bean1 bean1 = ctx.getBean(Bean1.class);
		System.out.println(bean1);
	}
}
