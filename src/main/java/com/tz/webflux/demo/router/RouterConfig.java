package com.tz.webflux.demo.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private TimeHandler timeHandler;

    //http://localhost/time
    //http://localhost/
    //http://localhost/times
    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return RouterFunctions
                .route(RequestPredicates.GET("/time"), req -> timeHandler.getTime(req))
                .andRoute(RequestPredicates.GET("/date"), timeHandler::getDate)
                .andRoute(RequestPredicates.GET("/times"), timeHandler::sendTimePerSec);
    }

}