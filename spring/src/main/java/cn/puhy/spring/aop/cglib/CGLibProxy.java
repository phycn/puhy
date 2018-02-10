package cn.puhy.spring.aop.cglib;

import java.lang.reflect.Method;

import cn.puhy.spring.aop.dynamicAgency.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class<?> clazz) {
		//设置需要创建子类的类
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		//通过字节码技术动态创建子类实例
		return enhancer.create();
	}
	
	//拦截父类所有方法的调用
	/**
	 * obj为目标类的实例
	 * method为目标类方法的反射对象
	 * args为方法的动态入参
	 * proxy为代理类实例
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		
		long start = PerformanceMonitor.getTime();
		//通过代理类调用父类中的方法
		Object result = proxy.invokeSuper(obj, args);
		
		long end = PerformanceMonitor.getTime();
		System.out.println("耗费时间：" + (end - start));
		return result;
	}
}
