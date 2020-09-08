package com.touchbiz.common.entity.exception;

import com.touchbiz.common.entity.result.IResultMsg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractException extends RuntimeException {

    @ApiModelProperty(name = "错误消息对象",reference = "IResultMsg",required = true)
    private IResultMsg msg;

    public AbstractException(IResultMsg error) {
        super(error.getMessage());
        this.setMsg(error);
    }

    public AbstractException(String error) {
        super(error);
    }


    public AbstractException(IResultMsg error, Throwable cause) {
        super(error.getMessage(), cause);
        this.setMsg(error);
    }

    /** Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.4
     */
    public AbstractException(Throwable cause) {
        super(cause);
        this.setMsg(IResultMsg.APIEnum.SERVER_ERROR);
    }
}
