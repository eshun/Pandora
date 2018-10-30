package com.esun.pandora.foundation.controller;

import com.alibaba.fastjson.JSONObject;
import com.esun.pandora.foundation.model.RestResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 */
@ControllerAdvice
public class BaseController implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        String methodName = returnType.getMethod().getName();
        //springfox.documentation.swagger.web.UiConfiguration
        String methods = "uiConfiguration,swaggerResources,getDocumentation";
        if (methods.contains(methodName)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(!(body instanceof RestResult)) {
            RestResult result = new RestResult();
            result.successResult(body);
            if(body instanceof String||body==null) { //Controller 请求返回String统一格式化
                response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);

                return JSONObject.toJSON(result).toString();
            }

            return result;
        }
        return body;
    }
}