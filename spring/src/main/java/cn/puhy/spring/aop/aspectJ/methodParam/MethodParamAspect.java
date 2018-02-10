package cn.puhy.spring.aop.aspectJ.methodParam;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MethodParamAspect {
	
	//args()函数
	//args(java.lang.String)表示方法入参为String类型的切点
	//@args(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)		表示入参有Anno1修饰
	
	@AfterReturning(value="args(java.lang.String)")
	public void test1() {
		System.out.println("入参类型是String");
	}
	
	@AfterReturning(value="@args(cn.puhy.spring.aop.aspectJ.methodPointcut.Anno1)")
	public void test2() {
		System.out.println("@args测试");
	}
}
