package com.esun.pandora.foundation.exception.auth;

import com.esun.pandora.foundation.exception.BaseException;

/**
 * Created by esun on 2018/10/22.
 */
public class UserNoPermissionException extends BaseException {
    public UserNoPermissionException() {
        super("用户无权限访问！");
    }
    public UserNoPermissionException(String message) {
        super(message);
    }
}
