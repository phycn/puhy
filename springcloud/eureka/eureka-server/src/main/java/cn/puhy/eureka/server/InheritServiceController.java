package cn.puhy.eureka.server;

import cn.puhy.springcloud.common.service.InheritService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-01 13:46
 */
@RestController
public class InheritServiceController implements InheritService {

    @Override
    public String inherit(@RequestParam("name") String name) {
        return "你好呀 " + name;
    }
}
