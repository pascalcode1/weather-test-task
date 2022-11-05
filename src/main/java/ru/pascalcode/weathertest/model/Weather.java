package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Weather.
 */
@ApiModel(description = "Weather entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    /**
     * Weather ID.
     */
    @Schema(description = "Weather ID")
    @Id
    private Long id;

    /**
     * Current temperature.
     */
    @Schema(description = "Current temperature")
    private Long temperature;

    /**
     * Current air humidity.
     */
    @Schema(description = "Current air humidity")
    private Long humidity;

    /**
     * City's ID.
     */
    @Schema(description = "City's ID")
    private Long cityId;
}
