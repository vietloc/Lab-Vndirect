package edu.hanoi.jazz.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.stereotype.Component;

@Component
public class UIdSource implements UserIdSource {
    @Override
    public String getUserId() {
        Authentication with = SecurityContextHolder.getContext().getAuthentication();
        return with.getName();
    }
}
