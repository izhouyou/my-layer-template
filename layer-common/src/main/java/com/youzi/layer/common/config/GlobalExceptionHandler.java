package com.youzi.layer.common.config;


import com.youzi.layer.common.util.ResultGeneratorUtils;
import com.youzi.layer.common.enumeration.ResultCode;
import com.youzi.layer.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * @author admin
 */
@RestControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 请求参数错误
     */
    public static final String BASE_PARAM_ERR_MSG = "参数校验不通过:%s";

    /**
     * 无效的请求
     */
    public static final String BASE_BAD_REQUEST_ERR_MSG = "无效的请求:%s";

    /**
     * 顶级的异常处理
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({Exception.class})
    public Result handleException(Exception e) {
        log.error("[handleException] ", e);
        return ResultGeneratorUtils.error("系统异常：" + e.getMessage());
    }

    /**
     * @methodName businessException
     * @description 自定义异常处理
     * @params e
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({BusinessException.class})
    public Result businessException(BusinessException e) {
        log.error("[businessException] ", e);
        return ResultGeneratorUtils.error(e.getCode(), e.getMessage());
    }

    /**
     * RuntimeException的异常处理
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler({RuntimeException.class})
    public Result runtimeExceptionHandler(RuntimeException ex) {
        log.error("[RuntimeException] ", ex);
        return ResultGeneratorUtils.error(ResultCode.INTERNAL_SERVER_ERROR.code(), "系统异常:" + ex.getMessage());
    }

    /**
     * 404页面处理
     *
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoHandlerFoundException.class})
    public Result serviceExceptionHandler(NoHandlerFoundException ex) {
        String msg = ex.getMessage() == null ? "" : ex.getMessage();
        return ResultGeneratorUtils.error(ResultCode.PAGE_NOT_FOUND.code(), msg);
    }

    /**
     * 缺少servlet请求参数抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public Result handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("[handleMissingServletRequestParameterException] 参数错误: " + e.getParameterName());
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), e.getMessage());
    }

    /**
     * 请求参数不能正确读取解析时，抛出的异常，比如传入和接受的参数类型不一致
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.warn("[handleHttpMessageNotReadableException] 参数解析失败：", e);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), String.format(BASE_PARAM_ERR_MSG, e.getMessage()));
    }

    /**
     * 请求参数无效抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        String message = getBindResultMessage(result);
        log.warn("[handleMethodArgumentNotValidException] 参数验证失败：" + message);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), message);
    }

    private String getBindResultMessage(BindingResult result) {
        FieldError error = result.getFieldError();
        String field = error != null ? error.getField() : "空";
        String code = error != null ? error.getDefaultMessage() : "空";
        return String.format("%s:%s", field, code);
    }

    /**
     * 方法请求参数类型不匹配异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public Result handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.warn("[handleMethodArgumentTypeMismatchException] 方法参数类型不匹配异常: ", e);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), e.getParameter().getParameterName() + ":" + e.getMessage());
    }

    /**
     * 请求参数绑定到controller请求参数时的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public Result handleHttpMessageNotReadableException(BindException e) {
        BindingResult result = e.getBindingResult();
        String message = getBindResultMessage(result);
        log.warn("[handleHttpMessageNotReadableException] 参数绑定失败：" + message);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), message);
    }

    /**
     * javax.validation:validation-api 校验参数抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public Result handleServiceException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        log.warn("[handleServiceException] 参数验证失败：" + message);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), message);
    }

    /**
     * javax.validation 下校验参数时抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ValidationException.class})
    public Result handleValidationException(ValidationException e) {
        log.warn("[handleValidationException] 参数验证失败：", e);
        return ResultGeneratorUtils.error(ResultCode.BASE_PARAM_ERR_CODE.code(), String.format(BASE_PARAM_ERR_MSG, e.getMessage()));
    }

    /**
     * 不支持该请求方法时抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.warn("[handleHttpRequestMethodNotSupportedException] 不支持当前请求方法: ", e);
        return ResultGeneratorUtils.error(ResultCode.BASE_BAD_REQUEST_ERR_CODE.code(), String.format(BASE_BAD_REQUEST_ERR_MSG, e.getMessage()));
    }

    /**
     * 不支持当前媒体类型抛出的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Result handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.warn("[handleHttpMediaTypeNotSupportedException] 不支持当前媒体类型: ", e);
        return ResultGeneratorUtils.error(ResultCode.BASE_BAD_REQUEST_ERR_CODE.code(), String.format(BASE_BAD_REQUEST_ERR_MSG, e.getMessage()));
    }


}

