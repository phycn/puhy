package cn.puhy.spring.event.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.event.Sender;

public class EventTest {
	
	@Test
	public void test() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/event/event-context.xml");
		
		Sender Sender = (cn.puhy.spring.event.Sender) ctx.getBean("sender");
		Sender.sendMessage("蒲红宇");
		ctx.destroy();
	}
}
