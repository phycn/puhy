package cn.puhy.spring.beanRelation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.beanRelation.inherit.Bean1;

public class InheritRelationTest {
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/beanRelation/beanRelation-context.xml");
		//继承了bean11的属性
		Bean1 bean1 = (Bean1) ctx.getBean("bean12");
		System.out.println(bean1);
	}
}
