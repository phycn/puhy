package cn.puhy.eureka.consumer.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author PUHY
 * 2018-07-01 22:47
 */
@Service
public class HystrixFirstService {

    @Autowired
    private RestTemplate restTemplate;

    //指定失败回调方法
    @HystrixCommand(fallbackMethod = "firstError")
    public String hystrixFirst() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    //失败回调方法，方法参数要跟指定@HystrixCommand了的方法相同
    public String firstError() {
        return "error";
    }
}
