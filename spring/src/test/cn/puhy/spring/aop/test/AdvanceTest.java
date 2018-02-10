package cn.puhy.spring.aop.test;

import cn.puhy.spring.aop.aspectJ.advance.Puhongyu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvanceTest {

	private Puhongyu phy;

	@Before
	public void init() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspectJ-advance.xml");
		phy = (Puhongyu) ctx.getBean("phy");
	}

//	@Test
	public void test() {

		phy.studySpring();
		System.out.println();
		phy.studyRedis(5);
	}

	//访问连接点信息
//	@Test
	public void testJoinPoint() {
		phy.study("mysql", "oracle");
	}

	//绑定连接点方法入参
	@Test
	public void testBindJoinPointParam() {
		phy.bindJoinPointParam("pyhton", 999);
	}

	@Test
	public void testBindProxyObject() {
		phy.studySpring();
	}

	@Test
	public void testBindReturnValue() {
		phy.getAge();
	}

	@Test
	public void testBindException() {
		try {
			phy.bindException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
