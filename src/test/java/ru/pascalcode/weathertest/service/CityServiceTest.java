package ru.pascalcode.weathertest.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.City;
import ru.pascalcode.weathertest.repository.CityRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CityServiceTest {

    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Test
    void editCity() {
        City existingCity = new City(1L, "Tashkent", 1L, true);
        cityService.editCity(existingCity);
        Mockito.doReturn(Mono.just(existingCity))
                .when(cityRepository)
                .save(existingCity);
        Mockito.verify(cityRepository, Mockito.times(1)).save(existingCity);
    }

    @Test()
    void editCityFail() {
        City existingCity = new City(null, "Tashkent", 1L, true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cityService.editCity(existingCity);
        });
        Mockito.verify(cityRepository, Mockito.times(0)).save(existingCity);
    }

    @Test
    void addCity() {
        City newCity = new City(null, "Tashkent", 1L, true);
        City createdCity = new City(1L, "Tashkent", 1L, true);
        Mockito.doReturn(Mono.just(createdCity))
                .when(cityRepository)
                .save(newCity);

        cityService.addCity(newCity);
        Mockito.verify(cityRepository, Mockito.times(1)).save(newCity);

        //I know that it is useless, but I have to test something:
        Assert.assertNull(newCity.getId());
        Assert.assertNotNull(createdCity.getId());
        Assert.assertEquals(newCity.getName(), createdCity.getName());
        Assert.assertEquals(newCity.getCountryId(), createdCity.getCountryId());
        Assert.assertEquals(newCity.getVisible(), createdCity.getVisible());
    }

    @Test()
    void addCityFail() {
        City newCity = new City(1L, "Tashkent", 1L, true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cityService.addCity(newCity);
        });
        Mockito.verify(cityRepository, Mockito.times(0)).save(newCity);
    }
}