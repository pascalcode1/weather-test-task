package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * City.
 */
@ApiModel(description = "City entity")
@Data
@NoArgsConstructor
public class City {

    /**
     * City ID.
     */
    @Id
    @Schema(description = "City ID")
    private Long id;

    /**
     * City name.
     */
    @Schema(description = "City name")
    private String name;

    /**
     * Country's ID of the city.
     */
    @Schema(description = "Country's ID of the city")
    private Long countryId;
}
