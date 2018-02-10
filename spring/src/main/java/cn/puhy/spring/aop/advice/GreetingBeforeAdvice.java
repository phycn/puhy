package cn.puhy.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 前置增强
 * @author puhongyu
 *
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

	//在目标类前调用
	/**
	 * method为目标类的方法
	 * args为方法的参数
	 * target为目标类实例
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println("hello " + clientName);
	}
}
