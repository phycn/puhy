common                              公共东西
    InheritService                  feign继承特性

eureka                              注册中心，里面也包含ribbon
    eureka-registercenter           服务注册中心
    eureka-server                   服务提供者
    eureka-consumer                 服务消费者
        cn.puhy.eureka.config       自定义负载均衡策略，不要跟启动类放在一起
            RibbonConfiguration     自定负载均衡

        ConsumerConfiguration       加载负载均衡，指定服务使用该策略的类，Ribbon配置的优先级：属性配置 > JAVA配置>ibbon默认配置

without-eureka                      不使用eureka

feign                               声明式调用服务
    FeignApplication                启动类
    FeignController                 声明式调用
    HelloService                    绑定指定服务的接口
    FeignInheritController          feign继承特性
    FeignInheritService             feign继承特性，继承公共接口，并指定具体服务

hystrix                             部署在客户端的
    HystrixFirstService             hystrix初体验，指定失败回调
    HystrixFirstController          hystrix初体验，调用服务，调用失败会断路