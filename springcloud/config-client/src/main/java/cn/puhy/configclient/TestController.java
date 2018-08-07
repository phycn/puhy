package cn.puhy.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-26 23:35
 */
@RestController
@RefreshScope
public class TestController {

    @Autowired
    private Environment environment;

    @Autowired
    private PeopleConfig peopleConfig;

    @Value("${phy}")
    String phy;

    //解密后的明文
//    @Value("${password}")
    private String password;

    @GetMapping("/phy")
    public String phy() {
        return phy;
    }

    @GetMapping("/password")
    public String password() {
        return password;
    }

    @GetMapping("/people")
    public String people() {
        return peopleConfig.getName() + " " + peopleConfig.getAge() + " " + peopleConfig.getAddr();
    }
}
