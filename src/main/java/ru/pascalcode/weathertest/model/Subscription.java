package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@ApiModel(description = "Subscription entity")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {

    @Id
    @Schema(description = "Subscription ID")
    private Long id;

    @Schema(description = "Subscribed User ID")
    private String userId;

    @Schema(description = "City ID")
    private Long cityId;

    public Subscription(String userId, Long cityId) {
        this.userId = userId;
        this.cityId = cityId;
    }
}
