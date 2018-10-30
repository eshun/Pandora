package com.esun.pandora.auth.server.controller;

import com.esun.pandora.auth.server.model.User;
import com.esun.pandora.auth.server.service.UserService;
import com.esun.pandora.auth.server.payload.LoginRequest;
import com.esun.pandora.auth.server.payload.LoginResponse;
import com.esun.pandora.auth.server.payload.SignUpRequest;
import com.esun.pandora.foundation.security.jwt.JwtTokenProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by esun on 2018/10/24.
 */
@Api(tags="登录接口模块")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/signin")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        System.out.println(loginRequest);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(),
                loginRequest.getPassword()
        );

        Authentication authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        return new LoginResponse(jwt);
    }

    @PostMapping("/signup")
    public User registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {

        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {

        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User result = userService.save(user);

        return result;
    }

    @ApiOperation("用户登录")
    @ApiImplicitParam(name = "username", value = "username", required = true, dataType = "String")
    @GetMapping("/checkUsernameAvailability")
    public Boolean checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userService.existsByUsername(username);
        return isAvailable;
    }

    @GetMapping("/checkEmailAvailability")
    public Boolean checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userService.existsByEmail(email);
        return isAvailable;
    }
}
