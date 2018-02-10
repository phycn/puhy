package cn.puhy.spring.javaConfig.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.puhy.spring.ioc.Car;
import cn.puhy.spring.javaConfig.ConfigBean2;
import cn.puhy.spring.javaConfig.ConfigBean3;

public class JavaConfigTest {
	
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigBean3.class);
	
	@Test
	public void test() {
		ConfigBean2 bean2 = ctx.getBean(ConfigBean2.class);
		System.out.println(bean2);
		
		Car car = (Car) ctx.getBean("car1");
		System.out.println(car);
		
		ctx.destroy();
	}
}
