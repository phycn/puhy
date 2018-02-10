package cn.puhy.spring.aop.test;

import org.junit.Test;

import cn.puhy.spring.aop.cglib.CGLibProxy;
import cn.puhy.spring.aop.dynamicAgency.Service;
import cn.puhy.spring.aop.dynamicAgency.ServiceImpl;

public class CGLibTest {
	
	@Test
	public void test() {
		CGLibProxy proxy = new CGLibProxy();
		//创建代理类
		Service service = (Service) proxy.getProxy(ServiceImpl.class);
		service.service1();
		service.service2();
	}
}	
