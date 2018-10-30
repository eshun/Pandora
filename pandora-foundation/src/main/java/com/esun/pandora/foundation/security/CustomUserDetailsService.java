package com.esun.pandora.foundation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by esun on 2018/10/24.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        UserDetails user = iUserService.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
//                .orElseThrow(() ->
//                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
//                );

        return user;
    }

    public UserDetails loadUserById(Long id) {
        UserDetails user = iUserService.findUserDetailsById(id);
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("User", "id", id)
//                );

        return user;
    }
}
