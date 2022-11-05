package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Subscription;
import ru.pascalcode.weathertest.model.SubscriptionView;
import ru.pascalcode.weathertest.service.SubscriptionService;

import java.nio.file.AccessDeniedException;
import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.ADMIN;
import static ru.pascalcode.weathertest.controller.RoleConstant.USER;

@Tag(name = "SubscriptionController", description = "Subscription Controller API")
@Api(value = "Subscription Controller", tags = {"SubscriptionController"})
@RestController
@RequestMapping("subs")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @Operation(summary = "A method that allows users to subscribe to the city's weather", tags = "SubscriptionController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Subscribed",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Subscription.class))
                    })
    })
    @GetMapping("subscribe-to-city/{cityId}")
    @RolesAllowed(USER)
    public Mono<Subscription> subscribeToCity(@PathVariable Long cityId) {
        return subscriptionService.subscribeToCity(cityId);
    }

    @Operation(summary = "A method that returns list of subscriptions for current user", tags = "SubscriptionController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the subscriptions",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SubscriptionView.class)))
                    })
    })
    @GetMapping("get-subscriptions")
    @RolesAllowed(USER)
    public Flux<SubscriptionView> getSubscriptions() {
        return subscriptionService.getCurrentUserSubscriptions();
    }

    @Operation(summary = "A method that returns list of all subscriptions for admin", tags = "SubscriptionController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the subscriptions",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SubscriptionView.class)))
                    })
    })
    @GetMapping("user-details")
    @RolesAllowed(ADMIN)
    public Flux<SubscriptionView> userDetails() {
        return subscriptionService.getAllSubscriptions();
    }

    @Operation(summary = "A method that allows unsubscribe from the weather", tags = "SubscriptionController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Unsubscribed",
                    content = {
                            @Content(mediaType = "application/json")
                    })
    })
    @DeleteMapping("unsubscribe")
    @RolesAllowed(USER)
    public Mono<Void> unsubscribe(@RequestBody Subscription subscription) throws AccessDeniedException {
        return subscriptionService.unsubscribe(subscription);
    }
}
