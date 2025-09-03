package co.com.bancolombia.api;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.user.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class Handler {

    private final UserUseCase userUseCase;

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().body(userUseCase.getUser(serverRequest.pathVariable("id")), User.class);
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(User.class)
                .flatMap(userUseCase::saveUser)
                .flatMap(savedUser -> {
                    URI location = URI.create("/api/users/" + savedUser.getId());
                    return ServerResponse.created(location).bodyValue(savedUser);
                });
    }

    public Mono<ServerResponse> listenPUTUseCase(ServerRequest serverRequest) {
        return ServerResponse.noContent().build();
    }

    public Mono<ServerResponse> listenDELETEUseCase(ServerRequest serverRequest) {
        return ServerResponse.noContent().build();
    }
}
