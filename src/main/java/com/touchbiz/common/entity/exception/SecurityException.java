package com.touchbiz.common.entity.exception;

/**
 * @Author: Steven Jiang(jiangyan@toplist.com)
 * @Date: 2018/11/2 下午2:46
 */

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;
import lombok.ToString;

/**
 * 越权访问异常，service层或者proxy层抛出的异常，严禁出现越权访问其他租户或者非授权的数据访问
 */
@ToString
@ApiModel("业务的安全异常模型")
public class SecurityException extends AbstractException {
    private static final long serialVersionUID = -644174310560232L;

    public SecurityException(String error) {
        super(error);
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