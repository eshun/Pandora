package com.esun.pandora.foundation.exception.auth;

import com.esun.pandora.foundation.exception.BaseException;

/**
 * Created by esun on 2018/10/22.
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException() {
        super("用户登录已失效！");
    }
    public UserInvalidException(String message) {
        super(message);
    }
}
