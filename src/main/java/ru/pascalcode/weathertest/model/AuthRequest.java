package ru.pascalcode.weathertest.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

/**
 * Request for getting JWT token.
 */
@ApiModel(description = "Request for getting JWT token")

@Getter
public class AuthRequest {

    private String username;

    private String password;

}
