package info.jiatu.jtlsp.common.util;

import info.jiatu.jtlsp.common.enumeration.ResultCode;
import info.jiatu.jtlsp.common.response.Result;

/**
 * @author admin
 */
public class ResultGeneratorUtils {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    private static final String DEFAULT_FAIL_MESSAGE = "ERROR";

    private ResultGeneratorUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> Result<T> success() {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(message).setData(data);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMessage(DEFAULT_SUCCESS_MESSAGE).setData(data);
    }

    public static <T> Result<T> error() {
        return new Result<T>().setCode(ResultCode.FAIL).setMessage(DEFAULT_FAIL_MESSAGE);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>().setCode(ResultCode.FAIL).setMessage(message);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<T>().setCode(code).setMessage(message);
    }

    public static <T> Result<T> gen(ResultCode resultCode) {
        return new Result<T>().setCode(resultCode.getCode()).setMessage(resultCode.getMessage());
    }

    public static <T> Result<T> gen(ResultCode resultCode, T data) {
        return new Result<T>().setCode(resultCode).setData(data);
    }

    public static <T> Result<T> gen(Integer code, String message, T data) {
        return new Result<T>().setCode(code).setMessage(message).setData(data);
    }
}
