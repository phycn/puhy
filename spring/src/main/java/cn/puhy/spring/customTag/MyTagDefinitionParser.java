package cn.puhy.spring.customTag;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * 标签解析器
 * @author puhongyu
 *
 */
public class MyTagDefinitionParser implements BeanDefinitionParser {

	@Override
	public BeanDefinition parse(Element element, ParserContext parserContext) {
		
		//通过BeanDefinitionBuilder创建bean定义
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyBean.class);
		
		//获取自定义标签的属性
		String field1 = element.getAttribute("field1");
		String field2 = element.getAttribute("field2");
		
		beanDefinitionBuilder.addPropertyValue("field1", field1);
		beanDefinitionBuilder.addPropertyValue("field2", field2);
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		
		//注册myBean定义
		parserContext.registerBeanComponent(new BeanComponentDefinition(beanDefinition, "myBean"));
		
		return null;
	}
}
