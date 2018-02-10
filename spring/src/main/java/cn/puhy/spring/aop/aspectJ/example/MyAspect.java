package cn.puhy.spring.aop.aspectJ.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect	//标识为一个切面
public class MyAspect {
	
	@Before("execution(* eat(..))")			//定义切点
	public void beforeEating() {				//增强逻辑实现
		System.out.println("吃饭前要洗手");
	}
}
