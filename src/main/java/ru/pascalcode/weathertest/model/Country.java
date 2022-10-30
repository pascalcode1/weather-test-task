package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Country.
 */
@ApiModel(description = "Country entity")
@Data
@NoArgsConstructor
public class Country {

    /**
     * Country ID.
     */
    @Id
    @Schema(description = "Country ID")
    private Long id;

    /**
     * Country name.
     */
    @Schema(description = "Country name")
    private String name;
}
