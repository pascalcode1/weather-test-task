package ru.pascalcode.weathertest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.pascalcode.weathertest.model.Weather;

/**
 * Repository for Weather.
 */
@Repository
public interface WeatherRepository extends ReactiveCrudRepository<Weather, Long> {
}
