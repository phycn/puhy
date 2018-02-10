package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.aspectJ.example.Person;

public class AspectJTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-context.xml");
		
		//已自动将切面织入目标bean
		Person p = (Person) ctx.getBean("person");
		p.eat();
		ctx.close();
	}
}
