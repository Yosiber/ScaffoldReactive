package co.com.bancolombia.model.user.gateways;

import co.com.bancolombia.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> getUser(String id);
    Mono<User> saveUser(User user);
    Mono<Void> updateUser(User user);
    Mono<Void> deleteUser(String id);
}
