package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Country;
import ru.pascalcode.weathertest.service.CountryService;

import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.ADMIN;

/**
 * Country Controller.
 */
@Tag(name = "CountryController", description = "Country Controller API")
@Api(value = "Country Controller", tags = {"CountryController"})
@RestController
@RequestMapping("country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Operation(summary = "Gets list of countries (ADMIN)", tags = "CountryController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the countries",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Country.class)))
                    })
    })
    @GetMapping("countries-list")
    @RolesAllowed(ADMIN)
    public Flux<Country> countriesList() {
        return countryService.countriesList();
    }

    @Operation(summary = "Edit Country (ADMIN)", tags = "CountryController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Country was updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Country.class))
                    })
    })
    @PostMapping("edit-country")
    @RolesAllowed(ADMIN)
    public Mono<Country> editCountry(@RequestBody Country country) {
        return countryService.editCountry(country);
    }
}
