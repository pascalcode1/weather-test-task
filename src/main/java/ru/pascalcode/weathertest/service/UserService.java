package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.User;
import ru.pascalcode.weathertest.repository.UserRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final KeycloakUserService keycloakUserService;

    private final Map<String, Long> userIdCache = new ConcurrentHashMap<>();

    @Autowired
    public UserService(UserRepository userRepository,
                       KeycloakUserService keycloakUserService) {
        this.userRepository = userRepository;
        this.keycloakUserService = keycloakUserService;
    }

    public Flux<User> userList() {
        return userRepository.findAll();
    }

    public Mono<User> editUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Returns ID of current user.
     *
     * @return ID
     */
    public Long getCurrentUserId() {
        String currentKeycloakUserId = SecurityContextHolder.getContext().getAuthentication().getName();
        if (userIdCache.containsKey(currentKeycloakUserId)) {
            return userIdCache.get(currentKeycloakUserId);
        }
        String username = keycloakUserService.getCurrentUserName();
        Long dbUserId = userRepository.getIdByUserName(username).block();
        userIdCache.put(currentKeycloakUserId, dbUserId);
        return dbUserId;
    }
}
