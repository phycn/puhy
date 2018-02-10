package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu;

public class MethodParamTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-methodParam.xml");
		
		Puhongyu phy = (Puhongyu) ctx.getBean("puhongyu");
		
		phy.eat();
		System.out.println();
		phy.eat("面包");
		System.out.println();
		phy.sleep("10");
		System.out.println();
		phy.paramHaveAnno(null);
		System.out.println();
		phy.paramDotHaveAnno(null);
	}
}
