common                              公共东西
    InheritService                  feign继承特性
    FeignHystrixService             Feign整合Hystrix的公共接口

eureka                              注册中心，里面也包含ribbon
    eureka-registercenter           服务注册中心
    eureka-server                   服务提供者
        InheritServiceController    feign相关，InheritService接口实现
        FeignHystrixServiceController   feign整合hystrix相关，FeignHystrixService
    eureka-consumer                 服务消费者
        ConsumerController          使用RestTemplate调用服务
        cn.puhy.eureka.config       自定义负载均衡策略，不要跟启动类放在一起
            RibbonConfiguration     自定负载均衡

        ConsumerConfiguration       加载负载均衡，指定服务使用该策略的类，Ribbon配置的优先级：属性配置 > JAVA配置 > ribbon默认配置

without-eureka                      不使用eureka

feign                               声明式调用服务
    FeignApplication                启动类
    FeignController                 声明式调用
    HelloService                    绑定指定服务的接口
    FeignInheritController          feign继承特性
    FeignInheritService             feign继承特性，继承公共接口，并指定具体服务

hystrix                             熔断器，部署在客户端的，在ConsumerApplication上加了注解@EnableCircuitBreaker
    HystrixFirstService             hystrix初体验，指定失败回调，也就是降级，使用注解的方式
    HystrixFirstController          hystrix初体验，调用服务，调用失败会断路

    HystrixDemotionCommand          使用代码的方式实现降级
    HystrixDemotionController       调用模拟降级

    HystrixFusingController         调用模拟熔断

    HystrixCurrentLimitingController    调用模拟限流，也包括缓存

feign-hystrix                       feign整合hystrix，配置里要开启hystrix
    FeignHystrixApplication         启动类，注意注解
    FeignHystrixController          入口，访问服务
    FeignHystrixFallback            降级逻辑实现
    FeignHystrixIntegration         指定具体服务和降级逻辑实现类
    FeignDisableHystrixConfig       禁用hystrix



   application-c1.properties        配置了原始监控，全是JSON的

zuul                                API网关，http://localhost:8080/hello可通过网关访问，http://localhost:9003/hello-service/hello，同时也实现了ribbon
    ZuulApplication                 启动类
    MyFilter                        请求过滤器
    MyFallbackProvider              容错降级，粒度是微服务级别，而不是API
    RateLimitFilter                 限流过滤器

config                              配置中心
    application.yml                 配置中心的配置文件
    bootstrap.yml                   配置了对称密钥，加密：http://localhost:9004/encrypt post传输明文，解密http://localhost:9004/decrypt post传输明文
                                    还需要将JCE的jar包放入JDK中，在git上配置的密文需要加上{cipher}
    rabbitmq                        spring cloud bus整合rabbitmq
        Producer                    rabbitmq生产者
        Consumer                    Consumer消费者
        RabbitConfig                rabbitmq配置

    ConfigController                发送消息

config-client                       从配置中心获取配置
    bootstrap.yml                   必要的配置文件，先加载
    TestController                  测试从git获取配置，@RefreshScope为配置有变动会进行更新，需要向配置中心发送POST请求，例如：http://localhost:9004/actuator/bus-refresh，
                                    可以用curl -X POST http://localhost:9004/actuator/bus-refresh/ 向配置中心发

    PeopleConfig                    获取GIT上配置文件里类似people.name这样的属性


stream
    StreamClient
    StreamProducer                  消息生产者
    StreamConsumer                  消息消费者
