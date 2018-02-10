package cn.puhy.spring.aop.test;

import java.lang.reflect.Proxy;

import org.junit.Test;

import cn.puhy.spring.aop.dynamicAgency.PerformanceHandler;
import cn.puhy.spring.aop.dynamicAgency.Service;
import cn.puhy.spring.aop.dynamicAgency.ServiceImpl;

public class DynamicAgencyTest {
	
	@Test
	public void test() {
		
		//希望被代理的目标类
		Service service = new ServiceImpl();
		//将目标代码和横切代码编织到一起
		PerformanceHandler handler = new PerformanceHandler(service);
		//创建代理实例
		Service proxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), handler);
		proxy.service1();
		proxy.service2();
	}
}
