package com.touchbiz.common.entity.exception;

import io.swagger.annotations.ApiModel;

/**
 * 业务异常，service层或者proxy层抛出的异常
 * @author steven
 * Date: 2018/11/2 下午2:46
 */

@ApiModel("业务的异常模型")
public class BizException extends RuntimeException  {

    private static final long serialVersionUID = -644174310560740232L;

    public BizException(String message){
        super(message);
    }

    public BizException(String message, Object ... params){
        super(String.format(message, params));
    }

    public BizException(Throwable cause)
    {
        super(cause);
    }

    public BizException(String message,Throwable cause)
    {
        super(message,cause);
    }
}