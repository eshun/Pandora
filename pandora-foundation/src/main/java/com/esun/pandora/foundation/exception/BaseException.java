package com.esun.pandora.foundation.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by esun on 2018/10/22.
 */
public class BaseException extends RuntimeException {
    private HttpStatus status = HttpStatus.OK;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public BaseException() {
    }


    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
