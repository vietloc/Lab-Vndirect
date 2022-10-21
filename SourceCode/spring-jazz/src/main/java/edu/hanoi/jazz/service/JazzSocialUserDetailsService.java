package edu.hanoi.jazz.service;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialAuthenticationException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "socialUserDetailService")
public class JazzSocialUserDetailsService implements SocialUserDetailsService {
    UserDAO userDAO;

    @Autowired
    @Qualifier(value = "jazzUserDetailsService")
    private UserDetailsService userDetailsService;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public SocialUserDetails loadUserByUserId(final String userId){
        UserDetails user = userDetailsService.loadUserByUsername(userId);
        if(user == null){
            throw new SocialAuthenticationException("No user mapped with social user "+userId);
        }
        return new SocialUser(user.getUsername(),user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),user.isAccountNonLocked(),user.getAuthorities());
    }
}
