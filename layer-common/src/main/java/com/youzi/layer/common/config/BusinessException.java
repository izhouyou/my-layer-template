package com.youzi.layer.common.config;

import com.youzi.layer.common.enumeration.ResultCode;
import lombok.Getter;

/**
 * @title BusinessException
 * @description 业务异常处理
 * @author izhouy
 * @dateTime 2022/10/14 13:14
 * @editNote
 */
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private int code = ResultCode.INTERNAL_SERVER_ERROR.code();

    /**
     * 异常描述
     */
    private String message;

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }

}
