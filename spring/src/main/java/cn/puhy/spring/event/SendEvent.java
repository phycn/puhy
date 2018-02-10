package cn.puhy.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * 事件源
 * @author puhongyu
 *
 */
public class SendEvent extends ApplicationContextEvent {

	private static final long serialVersionUID = -5391128875590199744L;
	private String to;
	
	public SendEvent(ApplicationContext source, String to) {
		super(source);
		this.to = to;
	}

	public String getTo() {
		return to;
	}
}
