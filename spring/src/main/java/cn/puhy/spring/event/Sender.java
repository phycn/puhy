package cn.puhy.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 事件广播器（事件源和事件监听器沟通的桥梁，负责把事件通知给事件监听器）
 * @author puhongyu
 *
 */
public class Sender implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void sendMessage(String to) {
		System.out.println("模拟发送消息。。。");
		SendEvent se = new SendEvent(applicationContext, to);
		//向容器所有事件监听器发送事件
		applicationContext.publishEvent(se);
	}
}
