package cn.puhy.spring5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author puhongyu
 * 2018/10/15 15:57
 */
@Component
public class UserHandler {

    @Autowired
    UserService userService;

    public Mono<ServerResponse> getUserList(ServerRequest request) {
        Flux<User> userFlux = userService.findUserList();
        userFlux.subscribe(user -> System.out.println(user.toString()));
        return ServerResponse.ok().body(userFlux, User.class);
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        String userId = request.pathVariable("userId");
        Mono<User> userMono = userService.findUserById(userId);
        userMono.subscribe(user -> System.out.println(user.toString()));
        return ServerResponse.ok().body(userMono, User.class);
    }
}
