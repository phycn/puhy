package cn.puhy.configserver;

import cn.puhy.configserver.rabbitmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/7/30 23:14
 */
@RestController
public class ConfigController {

    @Autowired
    private Producer producer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("mess") String mess) {
        return producer.send(mess);
    }
}
