package com.touchbiz.common.entity.exception;

/**
 * @Author: Steven Jiang(mrjiangyan@hotmail.com)
 * @Date: 2018/11/2 下午2:46
 */

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * 业务异常，service层或者proxy层抛出的异常
 */

@ToString
@ApiModel("业务的异常模型")
public class BizException extends AbstractException  {
    private static final long serialVersionUID = -644174310560740232L;

    public BizException(IResultMsg error) {
        super(error);
    }

    public BizException(String error) {
        super(error);
    }

    public BizException(IResultMsg error, Throwable cause) {
        super(error, cause);
    }

    public BizException(Throwable cause){
        super(IResultMsg.APIEnum.BIZ_ERRPR,cause);
    }
}