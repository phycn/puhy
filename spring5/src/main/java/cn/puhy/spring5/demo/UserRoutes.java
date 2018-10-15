package cn.puhy.spring5.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author puhongyu
 * 2018/10/15 16:09
 */

@Configuration
public class UserRoutes {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> routersFunction(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/api/users"), userHandler::getUserList)
                .and(RouterFunctions.route(RequestPredicates.GET("/api/user/{userId}"), userHandler::getUser));
    }
}


