package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Weather;
import ru.pascalcode.weathertest.service.WeatherService;

import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.ADMIN;

/**
 * Weather Controller.
 */
@Tag(name = "WeatherController", description = "Weather Controller API")
@Api(value = "Weather Controller", tags = {"WeatherController"})
@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Operation(summary = "Update Weather (ADMIN)", tags = "WeatherController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Weather was updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Weather.class))
                    })
    })
    @PostMapping("update-city-weather")
    @RolesAllowed(ADMIN)
    public Mono<Weather> updateCityWeather(@RequestBody Weather weather) {
        return weatherService.updateCityWeather(weather);
    }
}
