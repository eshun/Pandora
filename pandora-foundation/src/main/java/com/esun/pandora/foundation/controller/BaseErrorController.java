package com.esun.pandora.foundation.controller;

import com.alibaba.fastjson.JSONObject;
import com.esun.pandora.foundation.model.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;

/**
 * Created by esun on 2018/10/29.
 */
@Api(tags="error")
@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BaseErrorController extends AbstractErrorController {
    public BaseErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Value("${server.error.path:${error.path:/error}}")
    private static String errorPath = "/error";

    @ApiOperation("error")
    @RequestMapping
    @ResponseBody
    public Object handleErrors(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpStatus status = getStatus(request);
        Map<String, Object> body = getErrorAttributes(request,true);
        Object message=body.get("message");
        String path=body.get("path").toString();

        RestResult result = new RestResult();
        result.errResult(status.value(), message, path);

        return new ResponseEntity<Object>(result, status);
    }

    @ApiOperation("error")
    @RequestMapping(produces = "text/html")
    public ModelAndView handleHtml(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpStatus status = getStatus(request);

        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(
                request, true));
        Object message=model.get("message");
        String path=model.get("path").toString();

        RestResult result = new RestResult();
        result.errResult(status.value(), message, path);

        /*	使用response返回	*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(status.value());
        PrintWriter writer = response.getWriter();
        writer.write(JSONObject.toJSON(result).toString());
        writer.flush();
        writer.close();

        return null;
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }
}
