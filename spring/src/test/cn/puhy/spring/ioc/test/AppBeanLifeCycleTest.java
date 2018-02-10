package cn.puhy.spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.ioc.lifecycle.LifecycleCar;

public class AppBeanLifeCycleTest {
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/ioc/appLifecycle-context.xml");
		LifecycleCar car = ctx.getBean(LifecycleCar.class);
		System.out.println(car);
	}
}
