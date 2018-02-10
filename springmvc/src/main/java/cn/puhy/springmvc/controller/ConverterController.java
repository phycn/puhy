package cn.puhy.springmvc.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/converter")
public class ConverterController {


    //@RequestBody将请求报文体转换为字符串绑定到requestBody入参中
    //使用的是StringHttpMessageConverter转换器
    @RequestMapping(path = "/handle1")
    public String handle1(@RequestBody String requestBody) {

        System.out.println("requestBody:" + requestBody);
        return "first/success";
    }

    //将图片数据输出到响应流中
    //使用的是ByteArrayHttpMessageConverter转换器
    @ResponseBody
    @RequestMapping(path = "/handle2/{id}")
    public byte[] handle2(@PathVariable("id") String id) throws IOException {

        System.out.println("id" + id);
        Resource resource = new ClassPathResource("p1.jpg");
        return FileCopyUtils.copyToByteArray(resource.getInputStream());
    }

    //HttpEntity与@RequestBody相似
    @RequestMapping("/handle3")
    public String handle3(HttpEntity<String> httpEntity) {

        System.out.println(httpEntity.getHeaders().getContentLength());
        System.out.println(httpEntity.getBody());
        return "first/success";
    }

    //ResponseEntity与@ResponseBody相似
    @RequestMapping(path = "/handle4/{id}")
    public ResponseEntity<byte[]> handle4(@PathVariable("id") String id) throws IOException {

        System.out.println("id" + id);
        Resource resource = new ClassPathResource("p1.jpg");
        byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(data, HttpStatus.OK);
        return responseEntity;
    }
}
