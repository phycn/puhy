package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.aspectJ.methodParam.HaveAnno;
import cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu;

public class TargetClassTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-targetClass.xml");
		
		Puhongyu phy = (Puhongyu) ctx.getBean("puhongyu");
		
		phy.eat();
		System.out.println();
		HaveAnno ha = new HaveAnno();
		phy.paramHaveAnno(ha);
	}
}
