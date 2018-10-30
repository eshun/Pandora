package com.esun.pandora.foundation.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by esun on 2018/10/26.
 */
@Service
public interface IUserService {

    UserDetails findByUsernameOrEmail(String username, String email);

    UserDetails findUserDetailsById(Long id);
}
