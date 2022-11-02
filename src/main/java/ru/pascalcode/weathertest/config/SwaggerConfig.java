package ru.pascalcode.weathertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.pascalcode.weather"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Weather Service",
                "REST API for Weather Service",
                "1.0",
                "",
                new Contact("Vadim Timofeev", "pascalcode.ru", "pascalcode1@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licese.html",
                new ArrayList<>()
        );
    }

}
