package com.touchbiz.common.entity.exception;

import io.swagger.annotations.ApiModel;

/**
 * 越权访问异常，service层或者proxy层抛出的异常，严禁出现越权访问其他租户或者非授权的数据访问
 * @author steven
 */
@ApiModel("业务的安全异常模型")
public class SecurityException extends RuntimeException {

    private static final long serialVersionUID = -644174310560232L;

    public SecurityException(String message){
        super(message);
    }

    public SecurityException(String message, Object ... params){
        super(String.format(message, params));
    }

    public SecurityException(Throwable cause)
    {
        super(cause);
    }

    public SecurityException(String message,Throwable cause)
    {
        super(message,cause);
    }
}