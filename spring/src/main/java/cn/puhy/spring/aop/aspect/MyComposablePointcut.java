package cn.puhy.spring.aop.aspect;

import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class MyComposablePointcut {
	
	public Pointcut getComposablePointcut() throws NoSuchMethodException, SecurityException {
		
		//创建一个复合切点
		ComposablePointcut composablePointcut = new ComposablePointcut();
		//创建一个流程切点，由Puhongyu类的hear方法调用的增强才起作用
		Pointcut flowPointcut = new ControlFlowPointcut(Puhongyu.class, "hear");
		//创建一个方法名切点
		MethodMatcher methodNamePointcut = new NameMatchMethodPointcut();
		methodNamePointcut.matches(Zhoujielun.class.getMethod("sing", String.class), Zhoujielun.class);
		
		//组合两个切点进行交集操作，同时满足两种切点的才行，union为并集
		return composablePointcut.intersection(flowPointcut).intersection(methodNamePointcut);
	}
}
