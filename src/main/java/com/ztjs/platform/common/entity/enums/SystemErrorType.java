package com.ztjs.platform.common.entity.enums;

import lombok.Getter;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:22
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_UNAUTHORIZED(403, "未授权"),

    SYSTEM_ERROR(500, "系统异常"),
    SYSTEM_BUSY(501, "系统繁忙,请稍候再试"),

    GATEWAY_NOT_FOUND_SERVICE(804, "服务未找到"),
    GATEWAY_ERROR(805, "网关异常"),
    GATEWAY_CONNECT_TIME_OUT(806, "网关超时"),

    ARGUMENT_NOT_VALID(601, "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT(602, "上传文件大小超过限制");

    /**
     * 错误类型码
     */
    private Integer code;

    /**
     * 错误类型描述信息
     */
    private String msg;

    SystemErrorType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}