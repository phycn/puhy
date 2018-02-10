package cn.puhy.spring.aop.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.aop.advice.Monitorable;
import cn.puhy.spring.aop.aspect.Liudehua;
import cn.puhy.spring.aop.aspect.Puhongyu;
import cn.puhy.spring.aop.aspect.Zhoujielun;

public class AdvisorTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/aop/aspect-context.xml");
	}

	//动态切面
	@Test
	public void dynamicAspect() {
		Zhoujielun dynamic = (Zhoujielun) ctx.getBean("myDynamic");
		dynamic.sing("七里香");
		dynamic.sing("红尘客栈");

		dynamic.act();
		//后面不会再做静态检查
		dynamic.act();
		dynamic.act();
	}

	//流程切面
	@Test
	public void flowAspect() {
		Zhoujielun myFlowProxy = (Zhoujielun) ctx.getBean("myFlowProxy");
		Puhongyu phy = new Puhongyu();
		phy.setZhoujielun(myFlowProxy);

		//直接调用增强不起作用
		myFlowProxy.sing("菊花台");

		System.out.println("---------------------");
		//由指定方法调用增强就起了作用
		phy.hear("七里香");
	}
	
	@Test
	public void test() {

//		Zhoujielun zhoujielunTarget = (Zhoujielun) ctx.getBean("zhoujielunTarget");
//		zhoujielunTarget.sing("七里香");
//		
//		//可以看到Liudehua没有被织入，因为在MyAdvisor中做了过滤
//		Liudehua liudehuaTarget = (Liudehua) ctx.getBean("liudehuaTarget");
//		liudehuaTarget.sing("冰雨");
//		
//		//正则表达式匹配切面
//		System.out.println("<----------------------------->");
//		Liudehua liudehuaRegex = (Liudehua) ctx.getBean("regex");
//		liudehuaRegex.sing("哈哈");
//		
//		System.out.println("<----------------------------->");

		
		//############################################################################

		//############################################################################
		
//		Zhoujielun myComposableProxy = (Zhoujielun) ctx.getBean("myComposableProxy");
//		//直接调用不起作用
//		myComposableProxy.sing("红尘客栈");
//		
//		Puhongyu phy = new Puhongyu();
//		phy.setZhoujielun(myComposableProxy);
//		//只有sing方法有增强，因为有过滤，复合了两种切点
//		phy.hear("红尘客栈");
		//############################################################################
		//引介切面
		Zhoujielun myIntroductionProxy = (Zhoujielun) ctx.getBean("myIntroductionProxy");
		Monitorable Monitorable = (cn.puhy.spring.aop.advice.Monitorable) myIntroductionProxy;
		Monitorable.setTime(true);
		myIntroductionProxy.sing("外婆");
		
		ctx.close();
	}
}
