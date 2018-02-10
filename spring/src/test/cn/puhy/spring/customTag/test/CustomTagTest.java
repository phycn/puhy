package cn.puhy.spring.customTag.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.customTag.MyBean;

public class CustomTagTest {
	
	@Test
	public void test() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/customTag/customTag-context.xml");
		MyBean bean = (MyBean) ctx.getBean("myBean");
		System.out.println(bean);
		ctx.close();
	}
}
