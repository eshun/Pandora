package com.esun.pandora.foundation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

import java.sql.Timestamp;

/**
 *
 */
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestResult {
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private int code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息
     */
    private Object error;
    /**
     * 给前端进行页面展示的信息
     */
    private String message;
    /**
     * 请求失败返回请求路径
     */
    private String path;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private Timestamp timestamp;

    public RestResult() {
        this.code = -1;
        this.message = ResultCode.getMsg(code);
        this.timestamp = new Timestamp(new DateTime().getMillis());
    }

    public void successResult(Object data) {
        this.success = true;
        this.code = 0;
        this.message = null;
        this.data = data;
    }

    public void errResult(int code, Object error) {
        this.errResult(code, error, null);
    }

    public void errResult(int code, Object error, String path) {
        this.success = false;
        this.code = code == 200 ? 0 : code;
        this.message = ResultCode.getMsg(code);
        this.error = error;
        this.path = path;
    }
}
