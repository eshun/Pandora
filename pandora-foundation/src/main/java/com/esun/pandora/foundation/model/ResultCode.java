package com.esun.pandora.foundation.model;

import lombok.Getter;

/**
 * Created by esun on 2018/10/19.
 *
 201: '新建或修改数据成功。',
 202: '一个请求已经进入后台排队（异步任务）。',
 204: '删除数据成功。',
 400: '发出的请求有错误，服务器没有进行新建或修改数据的操作。',
 401: '用户没有权限（令牌、用户名、密码错误）。',
 403: '用户得到授权，但是访问是被禁止的。',
 404: '发出的请求针对的是不存在的记录，服务器没有进行操作。',
 406: '请求的格式不可得。',
 410: '请求的资源被永久删除，且不会再得到的。',
 422: '当创建一个对象时，发生一个验证错误。',
 500: '服务器发生错误，请检查服务器。',
 502: '网关错误。',
 503: '服务不可用，服务器暂时过载或维护。',
 504: '网关超时。',
 */
@Getter
public enum ResultCode {
    UNKONW_ERROR(-1, "未知错误"),
    BAD_REQUEST(400, "请求的服务错误"),
    UNAUTHORIZED(401, "用户没有权限（令牌、用户名、密码错误）"),
    NOT_FOUND(404, "请求的服务不存在"),
    METHOD_NOT_ALLOWED(405, "请求的服务错误"),
    INTERNAL_SERVER_ERROR(500, "服务器发生错误"),
    SUCCESS(0, "服务器成功返回请求的数据!");//200


    private int code;
    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsg(int code) {
        for (ResultCode c : ResultCode.values()) {
            if (c.getCode() == code) {
                return c.getMsg();
            }
        }
        return ResultCode.UNKONW_ERROR.getMsg();
    }
}
