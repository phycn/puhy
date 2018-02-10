package cn.puhy.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * 异常抛出增强
 * @author puhongyu
 *
 */
public class GreetingThrowAdvice implements ThrowsAdvice {
	
	//方法名必须为afterThrowing，前3个参数要么都提供，要么都不提供
	public void afterThrowing(Method method, Object[] args, Object target, Exception e) {
		System.out.println("抛出异常：" + e.getMessage());
	}
}
