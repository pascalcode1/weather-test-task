package ru.pascalcode.weathertest.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.pascalcode.weathertest.model.Country;

/**
 * Repository for Country.
 */
@Repository
public interface CountryRepository extends ReactiveCrudRepository<Country, Long> {
}
