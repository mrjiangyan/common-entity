package com.touchbiz.common.entity.exception;

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * 越权访问异常，service层或者proxy层抛出的异常，严禁出现越权访问其他租户或者非授权的数据访问
 * @author steven
 */
@ApiModel("业务的安全异常模型")
public class SecurityException extends AbstractException {
    private static final long serialVersionUID = -644174310560232L;

    public SecurityException(String error) {
        super(new IResultMsg(){

            @Override
            public Long getCode() {
                return APIEnum.SECURITY_ERROR.getCode();
            }

            @Override
            public String getMessage() {
                return error;
            }
        });
    }

    public SecurityException(IResultMsg error) {
        super(error);
    }

    public SecurityException(IResultMsg error, Throwable cause) {
        super(error, cause);
    }

    public SecurityException(Throwable cause){
        super(IResultMsg.APIEnum.SECURITY_ERROR,cause);
    }
}