package cn.puhy.spring5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public Flux<User> getAllUser() {
        return userService.findUserList();
    }
}
