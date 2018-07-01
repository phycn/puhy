package cn.puhy.springcloud.common.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 继承特性，接口分离
 * @author PUHY
 * 2018-07-01 13:44
 */
public interface InheritService {

    @RequestMapping("/inherit")
    String inherit(@RequestParam("name") String name);
}
