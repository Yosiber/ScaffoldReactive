package co.com.bancolombia.api;

import co.com.bancolombia.usecase.user.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/usecase/user/{id}"), handler::listenGETUseCase)
                .andRoute(POST("/api/usecase/create"), handler::listenPOSTUseCase)
                .andRoute(PUT("/api/usercase/update"), handler::listenPUTUseCase)
                .andRoute(DELETE("/api/usercase/delete/{id}"), handler::listenDELETEUseCase);
    }
}
