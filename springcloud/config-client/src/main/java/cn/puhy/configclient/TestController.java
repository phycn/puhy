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
public class TestController {

    @Autowired
    private Environment environment;

    @Value("${version}")
    String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
