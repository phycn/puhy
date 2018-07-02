package cn.puhy.feign;

import cn.puhy.springcloud.common.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")       //绑定指定服务
public interface HelloService {
    @RequestMapping("/hello")
    String hello();

    //有参数的调用
    @RequestMapping("/object")
    User object(@RequestParam("id") int id);
}
