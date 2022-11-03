package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.pascalcode.weathertest.model.User;
import ru.pascalcode.weathertest.service.UserService;

import javax.annotation.security.RolesAllowed;

import static ru.pascalcode.weathertest.controller.RoleConstant.ADMIN;

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


    @Operation(summary = "Gets list of users", tags = "UserController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the users",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @GetMapping("user-list")
    @RolesAllowed(ADMIN)
    public Flux<User> userList() {
        return userService.userList();
    }

    @Operation(summary = "Edit User", tags = "UserController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Use was updated",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))
                    })
    })
    @PostMapping("edit-user")
    @RolesAllowed(ADMIN)
    public Mono<User> editUser(@RequestBody User user) {
        return userService.editUser(user);
    }
}
