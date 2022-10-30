package ru.pascalcode.weathertest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.pascalcode.weathertest.model.City;

/**
 * Repository for City.
 */
@Repository
public interface CityRepository extends ReactiveCrudRepository<City, Long> {
}
