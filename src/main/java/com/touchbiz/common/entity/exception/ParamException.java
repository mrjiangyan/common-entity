package com.touchbiz.common.entity.exception;

import io.swagger.annotations.ApiModel;

/**
 * 运行时参数异常
 * @author steven
 */
@ApiModel("参数错误的异常模型")
public class ParamException extends RuntimeException {

    private static final long serialVersionUID = -4122738912199159492L;

    public ParamException(String message){
        super(message);
    }

    public ParamException(String message, Object ... params){
        super(String.format(message, params));
    }

    public ParamException(Throwable cause)
    {
        super(cause);
    }

    public ParamException(String message,Throwable cause)
    {
        super(message,cause);
    }
}