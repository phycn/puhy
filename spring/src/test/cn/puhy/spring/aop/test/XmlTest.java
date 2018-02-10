package cn.puhy.spring.aop.test;

import cn.puhy.spring.aop.aspectJ.methodParam.HaveAnno;
import cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu;
import cn.puhy.spring.aop.aspectJ.xml.MakeMoney;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-xml.xml");
		
		Puhongyu phy = (Puhongyu) ctx.getBean("puhongyu");
		phy.eat();
		System.out.println();
		phy.say();
		System.out.println();
		MakeMoney mm = (MakeMoney) phy;
		mm.makeManyMoney();
		System.out.println();
		phy.getAge();
	}
}
