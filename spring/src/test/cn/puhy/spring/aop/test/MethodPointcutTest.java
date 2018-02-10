package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu;

public class MethodPointcutTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-methodPointcut.xml");
		
		Puhongyu phy = (Puhongyu) ctx.getBean("puhongyu");
		
		phy.eat();
		phy.eat("面包");
		phy.say();
		phy.getAge();
	}
}
