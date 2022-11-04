package ru.pascalcode.weathertest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.pascalcode.weathertest.model.SubscriptionView;

@Repository
public interface SubscriptionViewRepository extends ReactiveCrudRepository<SubscriptionView, Long> {

    Flux<SubscriptionView> findAllByUserId(String userId);
}
