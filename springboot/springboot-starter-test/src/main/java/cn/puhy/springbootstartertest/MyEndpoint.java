package cn.puhy.springbootstartertest;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义端点
 *
 * @author PUHY
 * 2018-12-16 18:54
 */
@Component
@Endpoint(id = "phy", enableByDefault = true)   // 定义端点，id为端点id，enableByDefault是否在默认情况下启用端点
public class MyEndpoint {

    // 一个端点只能存在一个@ReadOperation 标注的方法
    // 它代表的是 HTTP 的 GET 请求
    @ReadOperation
    public Map<String, String> phy() {
        Map<String, String> map = new HashMap<>();
        map.put("phy", "蒲红宇");
        return map;
    }
}
