package ru.pascalcode.weathertest.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.User;

/**
 * Repository for City.
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByUsername(String name);

    @Query("select u.id as id from usr u where username = :username")
    Mono<Long> getIdByUserName(String username);

}
