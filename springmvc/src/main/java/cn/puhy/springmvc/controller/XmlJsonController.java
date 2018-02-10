package cn.puhy.springmvc.controller;

import cn.puhy.springmvc.domain.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xmlJson")
public class XmlJsonController {

    @RequestMapping("/handle1")
    public ResponseEntity<User> handle1(HttpEntity<User> httpEntity) {

        User user = httpEntity.getBody();
        System.out.println("user:" + user);

        user.setAge(28);
        user.setName("蒲红宇");
        user.setPassword("12345678");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
