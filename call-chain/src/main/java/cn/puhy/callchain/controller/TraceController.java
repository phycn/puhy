package cn.puhy.callchain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2019-03-24 22:40
 */
@RestController
public class TraceController {

    private static Logger logger = LoggerFactory.getLogger(TraceController.class);

    @GetMapping("/trace")
    public void test() {
        logger.info("puhongyu253399933");
    }
}
