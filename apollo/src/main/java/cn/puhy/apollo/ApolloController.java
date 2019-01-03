package cn.puhy.apollo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2019-01-03 23:44
 */
@RestController
public class ApolloController {

    @Value("${name}")
    private String name;

    @GetMapping("/getName")
    public String getName() {
        return name;
    }
}
