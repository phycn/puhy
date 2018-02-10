package cn.puhy.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//bean作用范围，prototype为原型，每次都会新建实例
@Scope("prototype")
public class AnnotationBean5 {
	
	//相当于spring中的init-method
	@PostConstruct
	public void init1() {
		System.out.println("我是初始方法1");
	}
	
	@PostConstruct
	public void init2() {
		System.out.println("我是初始方法2");
	}
	
	//相当于spring中的destory-method
	@PreDestroy
	public void destory1() {
		System.out.println("我是销毁方法1");
	}
	
	@PreDestroy
	public void destory2() {
		System.out.println("我是销毁方法2");
	}
}
