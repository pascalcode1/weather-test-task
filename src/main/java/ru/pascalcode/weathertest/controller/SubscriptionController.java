package ru.pascalcode.weathertest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Subscription;
import ru.pascalcode.weathertest.model.SubscriptionView;
import ru.pascalcode.weathertest.service.SubscriptionService;

import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.USER;

@RestController
@RequestMapping("subs")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("subscribe-to-city/{cityId}")
    @RolesAllowed(USER)
    public Mono<Subscription> subscribeToCity(@PathVariable Long cityId){
        return subscriptionService.subscribeToCity(cityId);
    }

    @GetMapping("get-subscriptions")
    @RolesAllowed(USER)
    public Flux<SubscriptionView> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }
}
