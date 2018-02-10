package cn.puhy.spring.aop.aspectJ.targetClass;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TargetClassAspect {
	
	//within(),@target(),@within(),target()都是针对的类，而不是方法
	//within(cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu)		匹配目标类Puhongyud的所有方法
	//within(cn.puhy.*)												cn.puhy包中的所有类，但不包括子包
	//within(cn.puhy..*)												cn.puhy包及子包中的类
	//@target(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)		匹配任意标注了@Anno1的类
	//@within(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)		匹配任意标注了@Anno1的类及其子类
	//target(cn.puhy.spring.aop.aspectJ.targetClass.MyInterface)		匹配MyInterface的所有子类
	
	@Before("within(cn.puhy.spring.aop.aspectJ.methodPointcut.Puhongyu)")
	public void test1() {
		System.out.println("within测试");
	}
	
	@AfterReturning("@within(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)")
	public void test2() {
		System.out.println("入参被Anno1标注！！");
	}
	
	@AfterReturning("target(cn.puhy.spring.aop.aspectJ.targetClass.MyInterface)")
	public void test3() {
		System.out.println("MyInterface的实现类");
	}
}
