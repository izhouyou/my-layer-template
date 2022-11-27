package info.jiatu.jtlsp.common.enumeration;

/**
 * 响应码枚举，参考HTTP状态码的语义
 *
 * @author admin
 */
public enum ResultCode {
    //成功
    SUCCESS(200, "Success"),
    // 201 Created-都未成功
    CREATED(201, "Created"),
    // 202-部分未成功
    PART(202, "Accepted"),
    // 204 No Content
    NO_CONTENT(204, "No Content"),
    // 自定义错误结束
    ACCOUNT_IS_REFUSE(210, "Customize"),
    // 继续选择
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    //失败
    FAIL(400, "Fail"),
    //未认证（签名错误）
    UNAUTHORIZED(401, "Not Permission"),
    // 页面未找到
    PAGE_NOT_FOUND(404, "Not Find"),
    //服务器内部错误
    INTERNAL_SERVER_ERROR(500, "Error"),
    //参数校验不通过 必填项为空
    BASE_PARAM_ERR_CODE(461, "Required Parameter Is Empty"),
    //参数校验不通过 格式错误
    BASE_BAD_REQUEST_ERR_CODE(462, "Wrong Format"),
    //参数校验不通过 参数不存在
    BASE_BAD_REPEAT_ERR_CODE(463, "Does Not Exist");

    /**
     * 代码编号
     */
    private final int code;

    /**
     * 默认消息
     */
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
