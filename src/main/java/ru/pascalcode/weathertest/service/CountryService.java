package ru.pascalcode.weathertest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.Country;
import ru.pascalcode.weathertest.repository.CountryRepository;

/**
 * Country Service
 */
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Flux<Country> countriesList() {
        return countryRepository.findAll();
    }

    /**
     * Edit country entity.
     *
     * @param country Country.
     * @return Updated countre.
     */
    public Mono<Country> editCountry(Country country) {
        return countryRepository.save(country);
    }
}
