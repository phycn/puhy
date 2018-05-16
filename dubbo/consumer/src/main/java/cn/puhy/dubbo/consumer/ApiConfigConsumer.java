package cn.puhy.dubbo.consumer;

import cn.puhy.dubbo.api.FirstService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class ApiConfigConsumer {

    public static void main(String[] args) {

        // 消费方应用信息，相当于xml中的<dubbo:application name="api_provider" />
        ApplicationConfig application = new ApplicationConfig();
        application.setName("api_consumer");

        //连接注册中心，相当于xml中的<dubbo:registry address="zookeeper://127.0.0.1:2181" />
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");

        //引用远程服务
        //实例很重，最好用单例模式
        ReferenceConfig<FirstService> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(FirstService.class);
        reference.setVersion("1.0");

        //和本地一样使用DemoService
        FirstService firstService = reference.get();
        firstService.sayHello("phy");
    }
}
