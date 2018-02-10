package cn.puhy.spring.annotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.annotation.AnnotationBean;
import cn.puhy.spring.annotation.AnnotationBean2;
import cn.puhy.spring.annotation.AnnotationBean3;
import cn.puhy.spring.annotation.AnnotationBean4;

public class AnnotationTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/annotation/annotation-context.xml");
		
		AnnotationBean bean0 = ctx.getBean(AnnotationBean.class);
		System.out.println(bean0);
		
		AnnotationBean2 bean2 = ctx.getBean(AnnotationBean2.class);
		System.out.println(bean2);
		
		AnnotationBean3 bean3 = ctx.getBean(AnnotationBean3.class);
		System.out.println(bean3);
		
		System.out.println("----------------------------------------");
		AnnotationBean4 bean4 = ctx.getBean(AnnotationBean4.class);
		bean4.getListAndMap();
		
		ctx.destroy();
	}
}
