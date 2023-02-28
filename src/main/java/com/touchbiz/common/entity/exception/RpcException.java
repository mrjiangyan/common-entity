package com.touchbiz.common.entity.exception;

import io.swagger.annotations.ApiModel;

/**
 * 远程调用异常
 *
 * date: 2018/11/6 17:29
 */
@ApiModel("RPC接口调用异常错误模型")
public class RpcException extends RuntimeException {
    private static final long serialVersionUID = -7469987183079292910L;

    public RpcException(String message){
        super(message);
    }

    public RpcException(String message, Object ... params){
        super(String.format(message, params));
    }

    public RpcException(Throwable cause)
    {
        super(cause);
    }

    public RpcException(String message,Throwable cause)
    {
        super(message,cause);
    }
}