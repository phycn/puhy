package cn.puhy.spring.inject.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.inject.method.MethodBean;
import cn.puhy.spring.inject.method.MethodBeanFactory;

public class MethodInjectTest {
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/inject/method-context.xml");
		MethodBeanFactory f = ctx.getBean(MethodBeanFactory.class);
		MethodBean bean1 = f.getMethodBean();
		MethodBean bean2 = f.getMethodBean();
		System.out.println(bean1 == bean2);
	}
}
