package cn.puhy.eureka.consumer.hystrix;

import cn.puhy.springcloud.common.bean.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @author PUHY
 * 2018-07-14 19:35
 */
public class HystrixDemotionCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Integer id;

    public HystrixDemotionCommand(String commandGroupKey, RestTemplate restTemplate, Integer id) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    //服务调用
    @Override
    protected User run() throws Exception {
        User user = new User();
        user.setId(id);
        user.setName("消费端的");
        return restTemplate.postForObject("http://hello-service/demotion",user, User.class);
    }

    //服务降级时所调用的Fallback()
    @Override
    protected User getFallback() {
        User user = new User();
        user.setId(9999);
        user.setName("降级了");
        return user;
    }
}
