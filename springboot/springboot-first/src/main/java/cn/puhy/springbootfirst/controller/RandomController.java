package cn.puhy.springbootfirst.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2018/5/11 08:48
 */
@RestController
public class RandomController {

    @Value("${random.string}")
    private String randomStr;

    @Value("${random.int}")
    private String randomInt;

    @Value("${uuid}")
    private String uuid;

    @GetMapping("/random")
    public String random() {
        return "randomStr:" + randomStr + ",randomInt:" + randomInt + ",uuid:" + uuid;
    }
}
