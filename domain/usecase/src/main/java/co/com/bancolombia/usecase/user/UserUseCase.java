package co.com.bancolombia.usecase.user;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;

    public Mono<User> getUser(String id) {
        return userRepository.getUser(id);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.saveUser(user);
    }

    public Mono<Void> updateUser(User user){
        return userRepository.updateUser(user);
    }

    public Mono<Void> deleteUser(String id){
        return userRepository.deleteUser(id);
    }


}
