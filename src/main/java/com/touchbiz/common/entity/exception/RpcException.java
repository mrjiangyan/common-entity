package com.touchbiz.common.entity.exception;

/**
 * @Author: Steven Jiang(mrjiangyan@hotmail.com)
 * @Date: 2018/11/14 下午2:42
 */

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModel;

/**
 * 远程调用异常
 *
 * @Author: Steven Jiang(mrjiangyan@hotmail.com)
 * @Date: 2018/11/6 下午5:29
 */
@ApiModel("RPC接口调用异常错误模型")
public class RpcException extends AbstractException {
    private static final long serialVersionUID = -7469987183079292910L;


    public RpcException(String error) {
        super(error);
    }

    public RpcException(IResultMsg error) {
        super(error);
    }

    public RpcException(IResultMsg error, Throwable cause) {
        super(error, cause);
    }

    public RpcException(Throwable cause){
        super(IResultMsg.APIEnum.FORWORDING_ERROR,cause);
    }
}