package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Weather representation for users.
 */
@ApiModel(description = "Weather representation for users")
@Table("v_subscription")
@Getter
public class SubscriptionView {

    @Id
    @Schema(description = "Subscription ID")
    private Long id;

    @Schema(description = "User ID")
    private String userId;

    @Schema(description = "City name")
    private String cityName;

    @Schema(description = "Current temperature in city")
    private Long temperature;

    @Schema(description = "Current air humidity in city")
    private Long humidity;

}
