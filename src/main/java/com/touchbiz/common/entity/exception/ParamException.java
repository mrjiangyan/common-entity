package com.touchbiz.common.entity.exception;

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * 运行时参数异常
 * @author steven
 */
@ApiModel("参数错误的异常模型")
public class ParamException extends AbstractException {

    private static final long serialVersionUID = -4122738912199159492L;

    public ParamException(IResultMsg error) {
        super(error);
    }

    public ParamException(String error) {
        super(new IResultMsg(){

            @Override
            public Long getCode() {
                return APIEnum.PARAM_ERROR.getCode();
            }

            @Override
            public String getMessage() {
                return error;
            }
        });
    }

    public ParamException(IResultMsg error, Throwable cause) {
        super(error, cause);
    }

    public ParamException(Throwable cause){
        super(IResultMsg.APIEnum.PARAM_ERROR,cause);
    }
}