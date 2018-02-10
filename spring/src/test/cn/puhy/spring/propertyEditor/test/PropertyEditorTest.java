package cn.puhy.spring.propertyEditor.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.propertyEditor.Bean2;

public class PropertyEditorTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/propertyEditor/propertyEditor-context.xml");
		Bean2 bean2 = (Bean2) ctx.getBean("bean2");
		System.out.println(bean2);
	}
}
