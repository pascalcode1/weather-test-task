package ru.pascalcode.weathertest.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.pascalcode.weathertest.model.AuthRequest;
import ru.pascalcode.weathertest.service.AuthService;

import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;

/**
 * Authentication Controller.
 */
@Tag(name = "AuthController", description = "Authentication Controller API")
@Api(value = "Auth Controller", tags = {"AuthController"})
@RestController
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Method returns JWT Bearer token for user.
     *
     * @param body    contains username and password.
     * @param request request.
     * @return
     * @throws URISyntaxException
     */
    @Operation(summary = "Returns JWT Bearer token", tags = "AuthController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "You are welcome!",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))
                    })
    })
    @PostMapping("auth")
    @ResponseBody
    public String auth(@RequestBody AuthRequest body,
                       HttpServletRequest request) throws URISyntaxException {
        return authService.getBearer(body, request);
    }
}
