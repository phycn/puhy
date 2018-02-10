package cn.puhy.spring.customTag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 注册标签解析器
 * @author puhongyu
 *
 */
public class MyTagNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("myBean", new MyTagDefinitionParser());
	}
}
