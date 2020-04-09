package cn.puhy.apidoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author puhongyu
 * 2020/3/5 11:19
 */
@RestController
public class Api1Controller {


    /**
     * @api {GET} /api1 api1
     * @apiVersion 1.0.0
     * @apiGroup Api1Controller
     * @apiName api1
     * @apiParam (请求参数) {Number} id
     * @apiParamExample 请求参数示例
     * id=1064
     * @apiSuccess (响应结果) {String} name
     * @apiSuccess (响应结果) {String} address
     * @apiSuccessExample 响应结果示例
     * {"address":"2HHVI","name":"YiP1FtM6"}
     */
    @GetMapping("/api1")
    public Api1Res api1(Api1Req req) {
        return new Api1Res();
    }
}

class Api1Req {
    private int id;
}

class Api1Res {
    private String name;
    private String address;
}
