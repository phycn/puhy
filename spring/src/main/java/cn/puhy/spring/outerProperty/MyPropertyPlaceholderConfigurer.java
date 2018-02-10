package cn.puhy.spring.outerProperty;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	//对特定属性的属性值进行转换
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		
		if(propertyName.equals("phy")) {
			propertyValue = DecodeUtil.decode(propertyValue);
		}
		System.out.println("propertyValue: " + propertyValue);
		return propertyValue;
	}
}
