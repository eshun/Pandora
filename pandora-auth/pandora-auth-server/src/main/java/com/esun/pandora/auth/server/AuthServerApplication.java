package com.esun.pandora.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by esun on 2018/10/24.
 */
@SpringBootApplication(scanBasePackages = "com.esun.pandora")
@EnableAutoConfiguration
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
