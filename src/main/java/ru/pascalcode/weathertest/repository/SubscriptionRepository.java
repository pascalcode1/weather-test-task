package ru.pascalcode.weathertest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.pascalcode.weathertest.model.Subscription;

@Repository
public interface SubscriptionRepository extends ReactiveCrudRepository<Subscription, Long> {

}
