package com.youzi.layer.common.util;

import com.youzi.layer.common.config.BusinessException;
import com.youzi.layer.common.enumeration.ResultCode;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * title ValidateUtils
 * Description 校验判断工具,可以消除部分if判断
 * CreateDate 2022/5/27 17:32
 *
 * @author izhouy
 */
public class ValidateUtils {

    public static void isTrue(Boolean value, int code, String msg) {
        if (!Boolean.TRUE.equals(value)) {
            throw new BusinessException(code, msg);
        }
    }

    public static void isTrue(Boolean value, String msg) {
        if (!Boolean.TRUE.equals(value)) {
            throw new BusinessException(ResultCode.FAIL.code(), msg);
        }
    }

    public static void isTrue(Boolean value, ResultCode respCode) {
        if (!Boolean.TRUE.equals(value)) {
            throw new BusinessException(respCode.code(), respCode.getMessage());
        }
    }

    public static void isFalse(Boolean value, int code, String msg) {
        if (!Boolean.FALSE.equals(value)) {
            throw new BusinessException(code, msg);
        }
    }

    public static void isFalse(Boolean value, String msg) {
        if (!Boolean.FALSE.equals(value)) {
            throw new BusinessException(ResultCode.FAIL.code(), msg);
        }
    }

    public static void isFalse(Boolean value, ResultCode respCode) {
        if (!Boolean.FALSE.equals(value)) {
            throw new BusinessException(respCode.code(), respCode.getMessage());
        }
    }

    public static void notEmpty(String value, int code, String msg) {
        if (value == null || value.isEmpty()) {
            throw new BusinessException(code, msg);
        }
    }

    public static void notEmpty(String value, ResultCode respCode) {
        if (value == null || value.isEmpty()) {
            throw new BusinessException(respCode.code(), respCode.getMessage());
        }
    }

    public static void notBlank(String value, int code, String msg) {
        if (StringUtils.isBlank(value)) {
            throw new BusinessException(code, msg);
        }
    }

    public static void notBlank(String value, String msg) {
        if (StringUtils.isBlank(value)) {
            throw new BusinessException(ResultCode.BASE_PARAM_ERR_CODE.code(), msg);
        }
    }

    public static void notNullParam(Object value) {
        if (value == null) {
            throw new BusinessException(ResultCode.BASE_PARAM_ERR_CODE.code(), "参数错误，不能为null");
        }
    }

    public static void notNull(Object value, int code, String msg) {
        if (value == null) {
            throw new BusinessException(code, msg);
        }
    }

    public static void notNullParam(Object value, String paramName) {
        if (value == null) {
            throw new BusinessException(ResultCode.BASE_PARAM_ERR_CODE.code(), "参数错误，" + paramName + "不能为null");
        }
    }


    public static void isNull(Object value, int code, String msg) {
        if (value != null) {
            throw new BusinessException(code, msg);
        }
    }

    public static void notEmptyParam(Collection value, String paramName) {
        if (value == null || value.isEmpty()) {
            throw new BusinessException(ResultCode.BASE_PARAM_ERR_CODE.code(), "参数错误，" + paramName + "不能为空");
        }
    }

    public static void isEmpty(Collection value, int code, String msg) {
        if (value != null && !value.isEmpty()) {
            throw new BusinessException(code, msg);
        }
    }

    public static <T> boolean isEquals(T expected, T actual) {
        return Objects.equals(expected, actual);
    }
}
