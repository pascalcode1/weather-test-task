package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Weather;
import ru.pascalcode.weathertest.repository.WeatherRepository;

/**
 * Service for weather.
 */
@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    /**
     * Updating of weather entity.
     *
     * @param weather Weather.
     * @return Updated weather.
     */
    public Mono<Weather> updateCityWeather(Weather weather) {
        return weatherRepository.save(weather);
    }
}
