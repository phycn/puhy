package cn.puhy.spring.aop.aspectJ.example;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class ExampleMain {
	public static void main(String[] args) {
		
		Person p = new Person();
		//
		AspectJProxyFactory factory = new AspectJProxyFactory();
		//设置目标对象
		factory.setTarget(p);
		//添加切面类
		factory.addAspect(MyAspect.class);
		//生成织入切面的代理对象
		Person proxy = factory.getProxy();
		
		proxy.eat();
	}
}
