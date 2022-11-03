package ru.pascalcode.weathertest.service;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class KeycloakUserService {

    /**
     * Returns username stored in the Keycloak by SecurityContext.
     * Keycloak Usernames are the same as usernames in database.
     *
     * @return username.
     */
    public String getCurrentUserName() {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Principal principal = (Principal) authentication.getPrincipal();
        KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
        return kPrincipal.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }
}
