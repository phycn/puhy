package cn.puhy.eureka.consumer.controller;

import cn.puhy.eureka.consumer.hystrix.HystrixDemotionCommand;
import cn.puhy.springcloud.common.bean.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 熔断调用
 *
 * @author PUHY
 * 2018-07-14 19:52
 */
@RestController
public class HystrixFusingController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("/fusing/{id}")
    public User fusing(@PathVariable Integer id) {
        System.out.println("被调用了，没有熔断");
        return restTemplate.getForObject("http://hello-service/fusing?id=" + id, User.class);
    }

    //增加Throwable对象可获取异常
    public User error(Integer id, Throwable e) {
        e.printStackTrace();
        User user = new User();
        user.setId(-1);
        user.setName("默认用户");
        return user;
    }
}
