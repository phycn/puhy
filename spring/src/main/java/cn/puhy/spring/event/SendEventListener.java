package cn.puhy.spring.event;

import org.springframework.context.ApplicationListener;

/**
 * 事件监听器
 * @author puhongyu
 *
 */
public class SendEventListener implements ApplicationListener<SendEvent> {

	@Override
	public void onApplicationEvent(SendEvent event) {
		System.out.println("向" + event.getTo() + "了发送一个消息");
	}
}
