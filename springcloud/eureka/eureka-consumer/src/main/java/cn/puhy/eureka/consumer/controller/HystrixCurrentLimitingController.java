package cn.puhy.eureka.consumer.controller;

import cn.puhy.springcloud.common.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 模拟限流，用Jmeter做测试，hystrix默认为10个线程，用大于10个的线程组发压测，多的线程会调用降级
 * @author PUHY
 * 2018-07-16 22:51
 */
@RestController
public class HystrixCurrentLimitingController {
    @Autowired
    private RestTemplate restTemplate;

    //groupKey为服务分组名，threadPoolKey为线程池名称，相同的会共用一个线程池
    //threadPoolProperties为线程池参数
    //commandProperties为命令参数
    @HystrixCommand(fallbackMethod = "error", groupKey = "helloService", threadPoolKey = "phyThreadPool")
    @GetMapping("/currentLimiting/{id}")
    public User currentLimiting(@PathVariable Integer id) {
        System.out.println("请求ID：" + id);
        return restTemplate.getForObject("http://hello-service/currentLimiting?id=" + id, User.class);
    }

    public User error(Integer id) {
        User user = new User();
        user.setId(-1);
        user.setName("默认用户");
        return user;
    }
}
