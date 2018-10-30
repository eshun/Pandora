package com.esun.pandora.auth.server.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by esun on 2018/10/25.
 */
@Getter
@Setter
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
