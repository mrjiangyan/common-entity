package com.touchbiz.common.entity.result;

import lombok.Getter;

import java.io.Serializable;

/**
 * 结果信息
 *
 * @author laisongxian
 * @version 1.0
 * @created 15/12/8 13:05
 **/
public interface IResultMsg extends Serializable {

    Long getCode();

    String getMessage();

    /**
     * 通用的枚举类型
     */
    enum APIEnum implements IResultMsg {
        // 通用码
        SUCCESS(0L, "成功"),
        FAILED(-1L, "失败"),
        PARAM_ERROR(-301L, "参数错误"),
        SERVER_ERROR(-500L, "服务器错误"),
        FORWORDING_ERROR(-501L, "下游服务访问异常"),
        PREVIOUS_ERROR(-502L, "上游服务传值异常"),
        SECURITY_ERROR(-503L, "安全性异常"),
        NOT_LOGIN_ERROR(-10101L, "请您登录"),
        UNAUTHORIZED(-401L, "鉴权不通过"),
        FORBIDDEN(-403L, "禁止访问"),
        TIME_OUT_ERROR(-10103L, "请求时间超时"),
        NO_PERMISSION(-10104L, "没有权限"),
        BIZ_ERRPR(-10200L, "业务异常");

        @Getter
        private Long code;
        @Getter
        private String message;

        APIEnum(Long code, String message) {
            this.code = code;
            this.message = message;
        }

    }
}
