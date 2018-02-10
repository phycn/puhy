package cn.puhy.spring.aop.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.aspectJ.introducing.JavaSkill;
import cn.puhy.spring.aop.aspectJ.introducing.PythonSkill;

public class IntroducingTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-introducing.xml");
		//这里必须用接口，有坑
		JavaSkill phy = (JavaSkill) ctx.getBean("phy");
		phy.useJava();
		System.out.println();
		//实现了PythonSkill接口
		PythonSkill ps = (PythonSkill) phy;
		ps.usePython();
	}
}
