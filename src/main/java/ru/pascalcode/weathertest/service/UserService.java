package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.User;
import ru.pascalcode.weathertest.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> userList() {
        return userRepository.findAll();
    }

    public Mono<User> editUser(User user) {
        return userRepository.save(user);
    }
}
