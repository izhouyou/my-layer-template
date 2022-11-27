package com.youzi.layer.common.response;

import com.youzi.layer.common.enumeration.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * 统一API响应结果封装
 *
 * @author admin
 */
@Getter
@ApiModel("统一返回结果实体类")
public class Result<T> {
    /**
     * 响应编号，参考ResultCode
     */
    @ApiModelProperty(value = "响应编号", required = true, example = "200")
    private int code;
    /**
     * 消息
     */
    @ApiModelProperty(value = "消息", example = "Success")
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty("返回数据")
    private T data;

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public Result<T> setCode(int resultCode) {
        this.code = resultCode;
        return this;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @ApiModelProperty(value = "响应结果", required = true, example = "true")
    public Boolean isSuccess() {
        return this.code >= ResultCode.SUCCESS.code() && this.code < ResultCode.MULTIPLE_CHOICES.code();
    }
}
