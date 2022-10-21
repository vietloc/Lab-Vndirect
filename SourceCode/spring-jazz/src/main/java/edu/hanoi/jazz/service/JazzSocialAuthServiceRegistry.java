package edu.hanoi.jazz.service;

import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.SocialAuthenticationService;

import javax.annotation.PostConstruct;
import java.util.List;

public class JazzSocialAuthServiceRegistry extends SocialAuthenticationServiceRegistry {
    private List<SocialAuthenticationService<?>> authenticationService;

    public JazzSocialAuthServiceRegistry(List<SocialAuthenticationService<?>> authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostConstruct
    public void init(){
        if(authenticationService == null){
            return;
        }
        authenticationService.forEach(auth -> super.addAuthenticationService(auth));
    }
}
