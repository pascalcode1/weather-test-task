package ru.pascalcode.weathertest.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.pascalcode.weathertest.model.AuthRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;

/**
 * Authentication Service.
 */
@Service
public class AuthService {

    @Value("${weather.keycloak.server}")
    private String server;

    @Value("${weather.keycloak.port}")
    private int port;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${weather.keycloak.grant-type}")
    private String grantType;

    @Value("${weather.keycloak.token-path}")
    private String tokenPath;

    private final String bodyPattern = "client_id=%s&grant_type=%s&username=%s&password=%s";

    /**
     * Method forwards a request to Keycloak and returns a bearer token.
     *
     * @param authRequest username and password.
     * @param request     request.
     * @return Bearer.
     * @throws URISyntaxException
     */
    public String getBearer(AuthRequest authRequest, HttpServletRequest request) throws URISyntaxException {
        URI uri = new URI("http", null, server, port, null, null, null);
        uri = UriComponentsBuilder.fromUri(uri)
                .path(tokenPath)
                .build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            if (headerName.equals("content-type")) {
                headers.set(headerName, MediaType.APPLICATION_FORM_URLENCODED.toString());
            } else {
                headers.set(headerName, request.getHeader(headerName));

            }
        }
        HttpEntity<String> httpEntity = new HttpEntity<>(
                String.format(bodyPattern, clientId, grantType, authRequest.getUsername(), authRequest.getPassword()),
                headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
            return "Bearer " + new JSONObject(response.getBody()).get("access_token");
        } catch (HttpClientErrorException e) {
            return e.getStatusCode().value() + " " + e.getStatusCode().getReasonPhrase();
        }
    }
}
