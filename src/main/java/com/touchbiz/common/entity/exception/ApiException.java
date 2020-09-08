package com.touchbiz.common.entity.exception;


import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * @author steven
 */
@ToString
@ApiModel("API接口的异常模型")
public class ApiException extends AbstractException  {

    public ApiException(IResultMsg error) {
        super(error);
    }

    public ApiException(IResultMsg error, Throwable cause) {
        super(error, cause);
    }

    public ApiException(Throwable cause){
        super(IResultMsg.APIEnum.SERVER_ERROR,cause);
    }

    public ApiException(String error) {
        super(error);
    }
}





