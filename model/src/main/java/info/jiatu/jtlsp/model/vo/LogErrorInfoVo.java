package info.jiatu.jtlsp.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志异常信息(LogErrorInfo)实体类
 *
 * @author izhouy
 * @since 2022-10-19 00:07:24
 */
@Getter
@Setter
@ApiModel("查询操作日志异常信息")
public class LogErrorInfoVo implements Serializable {
    private static final long serialVersionUID = 257297148291513538L;
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Long id;
    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String reqParam;
    /**
     * 异常名称
     */
    @ApiModelProperty(value = "异常名称")
    private String name;
    /**
     * 异常信息
     */
    @ApiModelProperty(value = "异常信息")
    private String message;
    /**
     * 操作用户id
     */
    @ApiModelProperty(value = "操作用户id")
    private String userId;
    /**
     * 操作用户名称
     */
    @ApiModelProperty(value = "操作用户名称")
    private String userName;
    /**
     * 请求方法
     */
    @ApiModelProperty(value = "请求方法")
    private String method;
    /**
     * 请求url
     */
    @ApiModelProperty(value = "请求url")
    private String uri;
    /**
     * 请求IP
     */
    @ApiModelProperty(value = "请求IP")
    private String ip;
    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private String version;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}

