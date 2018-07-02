package cn.puhy.feign;

import cn.puhy.springcloud.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-01 9:31
 */
@RestController
public class FeignController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/feign-hello")
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping("/object")
    public User object(@RequestParam("id") int id) {
        return helloService.object(id);
    }
}
