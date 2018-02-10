package cn.puhy.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * 环绕增强
 * @author puhongyu
 *
 */
public class GreetingInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		//目标方法参数
		Object[] args = invocation.getArguments();
		//在目标方法前执行
		System.out.println("开始了哦");
		//反射调用目标方法
		Object obj = invocation.proceed();
		//在目标方法后执行
		System.out.println("结束了哈");
		return obj;
	}
}
