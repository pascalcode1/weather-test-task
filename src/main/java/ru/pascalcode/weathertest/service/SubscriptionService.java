package ru.pascalcode.weathertest.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Subscription;
import ru.pascalcode.weathertest.model.SubscriptionView;
import ru.pascalcode.weathertest.repository.SubscriptionRepository;
import ru.pascalcode.weathertest.repository.SubscriptionViewRepository;

@Service
public class SubscriptionService {

    private final SubscriptionViewRepository subscriptionViewRepository;

    private final UserService userService;

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionViewRepository subscriptionViewRepository,
                               UserService userService, SubscriptionRepository subscriptionRepository) {
        this.subscriptionViewRepository = subscriptionViewRepository;
        this.userService = userService;
        this.subscriptionRepository = subscriptionRepository;
    }


    public Flux<SubscriptionView> getSubscriptions() {
        return subscriptionViewRepository.findAllByUserId(userService.getCurrentUserId());
    }

    public Mono<Subscription> subscribeToCity(Long cityId) {
        Subscription subscription = new Subscription(userService.getCurrentUserId(), cityId);
        return subscriptionRepository.save(subscription);
    }
}
