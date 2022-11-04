package ru.pascalcode.weathertest.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * Returns ID of current user from Security Context.
     *
     * @return ID
     */
    public String getCurrentUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
