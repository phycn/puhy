package cn.puhy.spring5.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author puhongyu
 * 2018/10/15 13:15
 */
@RestController
public class FirstController {

    @GetMapping("/first")
    public Mono<String> first() {
        return Mono.just("phy love zjj");
    }
}
