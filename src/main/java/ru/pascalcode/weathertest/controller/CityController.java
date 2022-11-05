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
import ru.pascalcode.weathertest.model.City;
import ru.pascalcode.weathertest.service.CityService;

import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.ADMIN;
import static ru.pascalcode.weathertest.controller.RoleConstant.USER;


/**
 * City Controller.
 */
@Tag(name = "CityController", description = "City Controller API")
@Api(value = "City Controller", tags = {"CityController"})
@RestController
@RequestMapping("city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Operation(summary = "Gets list of cities", tags = "CityController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the cities",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = City.class)))
                    })
    })
    @GetMapping("cities-list")
    @RolesAllowed({ADMIN, USER})
    public Flux<City> citiesList() {
        return cityService.citiesList();
    }

    @Operation(summary = "Edit city", tags = "CityController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = City.class))
                    })
    })
    @PostMapping("edit-city")
    @RolesAllowed(ADMIN)
    public Mono<City> editCity(@RequestBody City city) {
        return cityService.editCity(city);
    }

    @Operation(summary = "Add city", tags = "CityController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "City was added",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = City.class))
                    })
    })
    @PostMapping("add-city")
    @RolesAllowed(ADMIN)
    public Mono<City> addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }
}
