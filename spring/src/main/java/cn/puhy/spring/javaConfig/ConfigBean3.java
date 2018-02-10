package cn.puhy.spring.javaConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
//将其他配置类组装进来
@Import(ConfigBean1.class)
//引入XML配置文件
@ImportResource("classpath:cn/puhy/spring/ioc/ioc-context.xml")
public class ConfigBean3 {
	
}
