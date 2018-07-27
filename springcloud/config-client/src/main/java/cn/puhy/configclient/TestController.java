package cn.puhy.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-07-26 23:35
 */
@RestController
public class TestController {

    @Value("${version}")
    private String version;

    @GetMapping("/version")
    public String version() {
        return version;
    }
}
