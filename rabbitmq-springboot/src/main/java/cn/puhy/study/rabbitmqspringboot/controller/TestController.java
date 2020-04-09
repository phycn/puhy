package cn.puhy.study.rabbitmqspringboot.controller;

import cn.puhy.study.rabbitmqspringboot.producer.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PUHY
 * 2019-07-09 0:27
 */
@RestController
public class TestController {

    @Autowired
    private MQSender mqSender;

    /**
     * @api {GET} /send send
     * @apiVersion 1.0.1
     * @apiGroup TestController
     * @apiParam {String} [id=1] 用户id
     * @apiParam {String} [address[street]]
     * @apiParam {String} country="DE"
     * @apiName send
     * @apiDescription 测试
     * @apiSuccess (响应结果111) {String} name
     * @apiSuccess (响应结果111) {String} age
     * @apiSuccessExample 响应结果示例
     * {"name": "phy", "id": 1}
     */
    @GetMapping("/send")
    public void send() {
        mqSender.send();
    }
}
