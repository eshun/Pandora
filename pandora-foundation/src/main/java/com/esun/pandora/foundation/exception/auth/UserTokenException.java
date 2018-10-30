package com.esun.pandora.foundation.exception.auth;

import com.esun.pandora.foundation.exception.BaseException;

/**
 * Created by esun on 2018/10/22.
 */
public class UserTokenException extends BaseException {
    public UserTokenException() {
        super("用户登录异常！");
    }
    public UserTokenException(String message) {
        super(message);
    }
}
