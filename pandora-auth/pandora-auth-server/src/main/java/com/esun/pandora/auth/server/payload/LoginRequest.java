package com.esun.pandora.auth.server.payload;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by esun on 2018/10/25.
 */
@ApiModel(value = "用户登录信息")
@Getter
@Setter
public class LoginRequest {

    @ApiModelProperty(required = true, dataType = "String", name = "用户名")
    @NotBlank
    private String usernameOrEmail;

    @ApiModelProperty(required = true, dataType = "String", name = "密码")
    @NotBlank
    private String password;
}
