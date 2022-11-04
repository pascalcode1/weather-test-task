package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.weathertest.service.UserService;

/**
 * User Controller.
 */
@Tag(name = "UserController", description = "User Controller API")
@Api(value = "User Controller", tags = {"UserController"})
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

}
