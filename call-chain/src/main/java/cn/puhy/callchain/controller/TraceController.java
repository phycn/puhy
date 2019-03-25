package cn.puhy.callchain.controller;

import cn.puhy.callchain.TraceContext;
import cn.puhy.callchain.api.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
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

    @Reference
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(TraceController.class);

    @GetMapping("/trace")
    public void test() {
        userService.getUserName();
        logger.info("traceId: " + TraceContext.getTraceId());
    }
}
