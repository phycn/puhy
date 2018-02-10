package cn.puhy.spring.inject.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.inject.constructor.Bean2;

public class ConstructorTest {
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/inject/constructor-context.xml");
		Bean2 bean2 = ctx.getBean(Bean2.class);
		System.out.println(bean2.getField1() + " " + bean2.getField2());
	}
}
