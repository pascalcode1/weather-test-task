package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.City;
import ru.pascalcode.weathertest.repository.CityRepository;

/**
 * City Service.
 */
@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Flux<City> citiesList() {
        return cityRepository.findAll();
    }

    public Mono<City> addCity(City city) {
        if (city.getId() != null) {
            throw new IllegalArgumentException("The ID field of new City entity must be null");
        }
        return cityRepository.save(city);
    }

    public Mono<City> editCity(City city) {
        if (city.getId() == null) {
            throw new IllegalArgumentException("The ID field of the City entity must not be null");
        }
        return cityRepository.save(city);
    }
}
