package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.advice.Monitorable;
import cn.puhy.spring.aop.advice.Waiter;

public class AdviceTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aop-context.xml");
//		Waiter proxy = (Waiter) ctx.getBean("proxy");
//		proxy.greetTo("蒲红宇");
		
		//引介增强
		Waiter introducing = (Waiter) ctx.getBean("introducing");
		//将Waiter强制转换为Monitorable
		Monitorable Monitorable = (cn.puhy.spring.aop.advice.Monitorable) introducing;
		Monitorable.setTime(true);
		introducing.greetTo("蒲红宇");
		
		ctx.close();
		
		
	}
}
