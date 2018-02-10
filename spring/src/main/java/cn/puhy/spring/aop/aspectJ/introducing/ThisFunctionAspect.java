package cn.puhy.spring.aop.aspectJ.introducing;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ThisFunctionAspect {
	
	//this切点函数，与target相同，通过动态代理实现的也会匹配
	@AfterReturning("this(cn.puhy.spring.aop.aspectJ.introducing.PythonSkill)")
	public void testThis() {
		System.out.println("this切点函数");
	}
}
