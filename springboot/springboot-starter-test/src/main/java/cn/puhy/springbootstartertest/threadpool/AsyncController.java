package cn.puhy.springbootstartertest.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2018-12-16 20:20
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public String async() throws InterruptedException {
        asyncService.longTimeMethod();
        return "呵呵";
    }
}
