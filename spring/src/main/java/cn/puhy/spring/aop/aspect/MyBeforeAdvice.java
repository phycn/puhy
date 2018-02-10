package cn.puhy.spring.aop.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * 增强
 * @author puhongyu
 *
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		if(args.length != 0) {
			System.out.println("开始唱: " + args[0]);
		}
		else {
			System.out.println("没有参数的方法");
		}
	}
}
