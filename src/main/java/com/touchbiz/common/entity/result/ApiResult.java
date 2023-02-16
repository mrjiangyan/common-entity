//package com.touchbiz.common.entity.result;
//
//import com.touchbiz.common.entity.exception.AbstractException;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.math.BigInteger;
//import java.util.Map;
//
//
///**
// * @author: Steven Jiang(jiangyan@toplist.com.cn)
// * @date: 2018/9/28 12：00
// */
//@Data
//@ApiModel("返回结果的标准对象模型")
//public class ApiResult<T> implements Serializable {
//
//    @ApiModelProperty(value = "返回状态", reference = "IResultMsg", required = true)
//    private Integer status;
//
//    @ApiModelProperty(value = "返回状态对应的消息", required = true)
//    private String message;
//
//    @ApiModelProperty(value = "返回结果中的数据体")
//    private T data;
//
//    @ApiModelProperty(value = "异常的堆栈信息")
//    private Map errorInfo;
//
//    @ApiModelProperty(value = "返回的错误消息")
//    private String errorMessage;
//
//    /**
//     * 检查返回状态是否为成功状态
//     */
//    public boolean isSuccess() {
//        return status >= 0;
//    }
//
//    /**
//     * 静态方法检查返回结果是否为成功状态
//     *
//     */
//    public static boolean isSuccess(ApiResult result) {
//        if (result == null) {
//            return false;
//        }
//        return result.isSuccess();
//    }
//
//    public ApiResult() {
//    }
//
//    ApiResult(T data) {
//        this.status = IResultMsg.APIEnum.SUCCESS.getCode().intValue();
//        this.message = IResultMsg.APIEnum.SUCCESS.getMessage();
//        this.data = data;
//    }
//
//    ApiResult(T data, Long status, String message) {
//        this.status = status.intValue();
//        this.message = message;
//        this.data = data;
//    }
//
//    ApiResult(IResultMsg result) {
//        this.status = result.getCode().intValue();
//        this.message = result.getMessage();
//        this.data = null;
//    }
//
//    ApiResult(IResultMsg result, String message) {
//        this.status = result.getCode().intValue();
//        this.message = message;
//        this.data = null;
//    }
//
//    ApiResult(IResultMsg result, T data) {
//        this.status = result.getCode().intValue();
//        this.message = result.getMessage();
//        this.data = data;
//    }
//
//    ApiResult(Long status, String message) {
//        this.status = status.intValue();
//        this.message = message;
//        this.data = null;
//    }
//
//    /**
//     * 返回操作成功对应的API响应
//     *
//     * @return API响应对象
//     */
//    public static <T> ApiResult<T> getSuccessResponse() {
//        return ApiResult.getCustomResponse(IResultMsg.APIEnum.SUCCESS);
//    }
//
//    /**
//     * 返回操作成功对应的API响应
//     *
//     * @return API响应对象
//     */
//    public static <T> ApiResult<T> getSuccessResponse(T data) {
//        assert !(data instanceof IResultMsg);
//        return ApiResult.getCustomResponse(IResultMsg.APIEnum.SUCCESS, data);
//    }
//
//    /**
//     * 返回自定义的任意数据
//     *
//     * @param status 状态
//     * @param data   数据
//     * @return API响应对象
//     */
//    public static <T> ApiResult<T> getCustomResponse(IResultMsg status, T data) {
//        ApiResult<T> apiResult = getCustomResponse(status);
//        apiResult.setData(data);
//        return apiResult;
//    }
//
//
//    /**
//     * 返回结果码对应的API响应
//     *
//     * @param status 状态
//     * @return API响应对象
//     */
//    public static <T> ApiResult<T> getCustomResponse(IResultMsg status) {
//        ApiResult<T> apiResult = new ApiResult<>();
//        apiResult.setStatus(status.getCode().intValue());
//        apiResult.setMessage(status.getMessage());
//        return apiResult;
//    }
//
//
//    public static <T> ApiResult<T> getErrorResponse(Throwable e) {
//        ApiResult<T> apiResult = new ApiResult<>();
//        if (e instanceof AbstractException && ((AbstractException) e).getMsg() != null) {
//            AbstractException exception = (AbstractException) e;
//            apiResult.setStatus(exception.getMsg().getCode().intValue());
//            apiResult.setMessage(e.getMessage());
//        } else {
//            apiResult.setStatus(IResultMsg.APIEnum.FAILED.getCode().intValue());
//            apiResult.setMessage(e.getMessage());
//        }
//        apiResult.setErrorInfo(ExceptionUtils.getExceMainInfo(e));
//        apiResult.setErrorMessage(e.getMessage());
//        return apiResult;
//    }
//
//    /**
//     * 在失败的情况下拷贝错误消息等
//     *
//     * @param result
//     * @param <T>
//     * @return
//     */
//    public static <T> ApiResult<T> convertApiResult(ApiResult result) {
//        if (result == null) {
//            return ApiResult.getCustomResponse(IResultMsg.APIEnum.FAILED);
//        }
//        ApiResult<T> apiResult = new ApiResult<>();
//        apiResult.setErrorMessage(result.errorMessage);
//        apiResult.setStatus(result.status);
//        apiResult.setErrorInfo(result.errorInfo);
//        apiResult.setMessage(result.message);
//        return apiResult;
//    }
//
//
//}