package cn.puhy.spring.aop.dynamicAgency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
	
	private Object object;
	public PerformanceHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		long start = PerformanceMonitor.getTime();
		//反射调用目标方法
		Object obj = method.invoke(object, args);
		long end = PerformanceMonitor.getTime();
		System.out.println("耗费时间：" + (end - start));
		
		return obj;
	}
}
