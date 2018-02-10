package cn.puhy.spring.factoryBean.test;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.puhy.spring.factoryBean.MyBean;
import cn.puhy.spring.factoryBean.MyFactoryBean;

public class FactoryBeanTest {
	
	@Test
	public void test() {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("cn/puhy/spring/factoryBean/factoryBean-context.xml");
		
		//获取的是自定义工厂类创建的bean
		MyBean myBean = ctx.getBean(MyBean.class);
		System.out.println(myBean);
		
		//通过&+beanName方式获取工厂类实例
		MyFactoryBean myFactoryBean = (MyFactoryBean) ctx.getBean("&myFactoryBean");
		System.out.println(myFactoryBean);
		ctx.destroy();
	}
}
