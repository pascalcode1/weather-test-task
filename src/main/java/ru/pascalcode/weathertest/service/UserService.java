package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.User;
import ru.pascalcode.weathertest.repository.UserRepository;

@Service
public class UserService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .cast(UserDetails.class);
    }

    public Flux<User> userList() {
        return userRepository.findAll();
    }

    public Mono<User> editUser(User user) {
        return userRepository.save(user);
    }
}
