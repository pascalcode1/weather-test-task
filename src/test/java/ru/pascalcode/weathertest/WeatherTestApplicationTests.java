package ru.pascalcode.weathertest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.pascalcode.weathertest.repository.CityRepository;

@SpringBootTest
class WeatherTestApplicationTests {

    @Mock
    CityRepository cityRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void givenEmployeeId_whenGetEmployeeById_thenCorrectEmployee() {
//        WebTestClient client = WebTestClient
//                .bindToRouterFunction(config.getEmployeeByIdRoute())
//                .build();

//        City employee = new City("russia");

//        given(cityRepository.getById()).willReturn(Mono.just(employee));

//        client.get()
//                .uri("/qweqwewqe/1")
//                .exchange()
//                .expectStatus()
//                .isOk()
//                .expectBody(City.class)
//                .isEqualTo(employee);
    }


//    @Test
//    void whenGetAllEmployees_thenCorrectEmployees() {
//        WebTestClient client = WebTestClient
//                .bindToRouterFunction(config.getAllEmployeesRoute())
//                .build();
//
//        List<Employee> employees = Arrays.asList(
//                new Employee("1", "Employee 1"),
//                new Employee("2", "Employee 2"));
//
//        Flux<Employee> employeeFlux = Flux.fromIterable(employees);
//        given(employeeRepository.findAllEmployees()).willReturn(employeeFlux);
//
//        client.get()
//                .uri("/employees")
//                .exchange()
//                .expectStatus()
//                .isOk()
//                .expectBodyList(Employee.class)
//                .isEqualTo(employees);
//    }


//    @Test
//    void whenUpdateEmployee_thenEmployeeUpdated() {
//        WebTestClient client = WebTestClient
//                .bindToRouterFunction(config.updateEmployeeRoute())
//                .build();
//
//        Employee employee = new Employee("1", "Employee 1 Updated");
//
//        client.post()
//                .uri("/employees/update")
//                .body(Mono.just(employee), Employee.class)
//                .exchange()
//                .expectStatus()
//                .isOk();
//
//        verify(employeeRepository).updateEmployee(employee);
//    }

}
