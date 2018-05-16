package cn.puhy.dubbo.provider;

import java.io.IOException;

import cn.puhy.dubbo.api.FirstService;
import cn.puhy.dubbo.provider.service.FirstServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;


public class ApiConfigProvider {

	public static void main(String[] args) throws IOException {
		
		FirstService firstService = new FirstServiceImpl();
		
		//提供方应用信息，相当于xml中的<dubbo:application name="api_provider" />
		ApplicationConfig application = new ApplicationConfig();
		application.setName("api_provider");
		
		//连接注册中心，相当于xml中的<dubbo:registry address="zookeeper://127.0.0.1:2181" />
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		
		//服务提供方协议配置，相当于xml中的<dubbo:protocol name="dubbo" port="20880" />
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(20880);
		
		//服务提供方暴露服务配置
		//实例很重，最好用单例模式
		ServiceConfig<FirstService> service = new ServiceConfig<>();
		service.setApplication(application);
		service.setRegistry(registry);
		service.setProtocol(protocol);
		service.setInterface(FirstService.class);
		service.setRef(firstService);
		service.setVersion("1.0");
		
		//暴露及注册服务
		service.export();
		System.in.read();
	}
}
