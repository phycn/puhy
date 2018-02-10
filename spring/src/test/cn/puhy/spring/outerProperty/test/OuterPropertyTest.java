package cn.puhy.spring.outerProperty.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.common.CommonBean;

public class OuterPropertyTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/outerProperty/outerProperty-context.xml");
		CommonBean bean = (CommonBean) ctx.getBean("commonBean");
		System.out.println(bean);
		ctx.destroy();
	}
}
