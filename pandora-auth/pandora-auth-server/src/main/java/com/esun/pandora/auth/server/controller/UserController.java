package com.esun.pandora.auth.server.controller;

import com.esun.pandora.foundation.security.CurrentUser;
import com.esun.pandora.foundation.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by esun on 2018/10/25.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public UserPrincipal getUserProfile(@CurrentUser UserPrincipal currentUser) {
        return currentUser;
    }
}
