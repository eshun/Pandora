package com.esun.pandora.foundation.controller;

import com.esun.pandora.foundation.exception.BaseException;
import com.esun.pandora.foundation.model.RestResult;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by esun on 2018/10/29.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return responseEntity(
                ((ServletWebRequest) request).getRequest(),
                ex,
                status);

    }

    @ExceptionHandler(value = Exception.class)
    public Object defaultExceptionHandler(HttpServletRequest request, Exception ex, HttpServletResponse response) {
        return responseEntity(request, ex,null);
    }

    private ResponseEntity<Object> responseEntity(HttpServletRequest request, Exception ex, HttpStatus status) {
        RestResult result = new RestResult();
        String url = request.getRequestURI();
        Object message =null;
        if(ex!=null){
            message = ex.getMessage();


            if (ex instanceof BaseException) {
                status = ((BaseException) ex).getStatus();
            } else {
                if (ex instanceof MissingServletRequestParameterException) {

                }
            }
        }
        if(status!=null){

            result.errResult(status.value(), message, url);
            return new ResponseEntity<Object>(result, status);
        }else{

            result.errResult(-1, message, url);
            return new ResponseEntity<Object>(result, HttpStatus.OK);
        }
    }
}
