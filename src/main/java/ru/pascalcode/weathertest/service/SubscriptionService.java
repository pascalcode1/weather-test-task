package ru.pascalcode.weathertest.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Subscription;
import ru.pascalcode.weathertest.model.SubscriptionView;
import ru.pascalcode.weathertest.repository.SubscriptionRepository;
import ru.pascalcode.weathertest.repository.SubscriptionViewRepository;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

/**
 * Subscription Service.
 */
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

    /**
     * Get all subscriptions for the current user.
     *
     * @return subscriptions.
     */
    public Flux<SubscriptionView> getCurrentUserSubscriptions() {
        return subscriptionViewRepository.findAllByUserId(userService.getCurrentUserId());
    }

    public Flux<SubscriptionView> getAllSubscriptions() {
        return subscriptionViewRepository.findAll();
    }

    public Mono<Subscription> subscribeToCity(Long cityId) {
        Subscription subscription = new Subscription(userService.getCurrentUserId(), cityId);
        return subscriptionRepository.save(subscription);
    }

    /**
     * Deletes subscription.
     *
     * @param subscription
     * @return
     */
    public Mono<Void> unsubscribe(Subscription subscription) throws AccessDeniedException {
        if (Objects.equals(subscription.getUserId(), userService.getCurrentUserId())) {
            return subscriptionRepository.delete(subscription);
        }
        throw new AccessDeniedException("Access denied!");
    }
}
