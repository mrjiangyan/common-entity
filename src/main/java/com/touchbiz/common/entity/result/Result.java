package com.touchbiz.common.entity.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *   接口返回数据格式
 * @author scott
 * @email jeecgos@163.com
 * @date  2019年1月19日
 */
@Data
@ApiModel(value="接口返回对象", description="接口返回对象")
public class Result<T> implements Serializable {

	/**
	 * 成功标志
	 */
	@ApiModelProperty(value = "成功标志")
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	@ApiModelProperty(value = "返回处理消息")
	private String message = "";

	/**
	 * 返回代码
	 */
	@ApiModelProperty(value = "返回代码")
	private Integer code = 0;
	
	/**
	 * 返回数据对象 data
	 */
	@ApiModelProperty(value = "返回数据对象")
	private T result;
	
	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
	private long timestamp = System.currentTimeMillis();

	public Result() {
	}

    /**
     * 兼容VUE3版token失效不跳转登录页面
     */
	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Result<T> success(String message) {
		this.message = message;
		this.code = 200;
		this.success = true;
		return this;
	}

	public static<T> Result<T> ok() {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		return r;
	}

	public static<T> Result<T> ok(String msg) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		//Result OK(String msg)方法会造成兼容性问题 issues/I4IP3D
		r.setResult((T) msg);
		r.setMessage(msg);
		return r;
	}

	public static<T> Result<T> ok(T data) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> OK() {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		return r;
	}

	/**
	 * 此方法是为了兼容升级所创建
	 *
     */
	public static<T> Result<T> OK(String msg) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		r.setMessage(msg);
		//Result OK(String msg)方法会造成兼容性问题 issues/I4IP3D
		r.setResult((T) msg);
		return r;
	}

	public static<T> Result<T> OK(T data) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> OK(String msg, T data) {
		Result<T> r = new Result<>();
		r.setSuccess(true);
		r.setCode(200);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> error(String msg, T data) {
		Result<T> r = new Result<>();
		r.setSuccess(false);
		r.setCode(500);
		r.setMessage(msg);
		r.setResult(data);
		return r;
	}

	public static<T> Result<T> error(String msg) {
		return error(500, msg);
	}
	
	public static<T> Result<T> error(int code, String msg) {
		Result<T> r = new Result<>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}

	public Result<T> error500(String message) {
		this.message = message;
		this.code = 500;
		this.success = false;
		return this;
	}

	/**
	 * 无权限访问返回结果
	 */
	public static<T> Result<T> noauth(String msg) {
		return error(510, msg);
	}


}