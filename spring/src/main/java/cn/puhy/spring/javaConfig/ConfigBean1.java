package cn.puhy.spring.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//提供bean的定义信息
@Configuration
public class ConfigBean1 {
	
	//与xml配置相同<bean id="configBean2" class="cn.puhy.spring.javaConfig.ConfigBean2" />
	@Bean
	public ConfigBean2 setConfigBean2() {
		return new ConfigBean2();
	}
}
