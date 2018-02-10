package cn.puhy.spring.beanRelation.test;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.beanRelation.dependence.CacheManager;
import cn.puhy.spring.beanRelation.inherit.Bean1;

public class DependenceRelationTest {
	
	@Test
	public void test() {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/beanRelation/dependence-context.xml");
		CacheManager cacheManager = (CacheManager) ctx.getBean("manager");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(cacheManager);
	}
}
