package com.ztjs.platform.model.po.log;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户操作日志 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 17:55
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_operation_log")
public class OperationLogPo implements Serializable {

    private static final long serialVersionUID = 4403354118132031054L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户登录账号
     */
    @TableField(value = "LOGIN_NAME")
    private String loginName;

    /**
     * 类名称
     */
    @TableField(value = "CLASS_NAME")
    private String className;

    /**
     * 方法名称
     */
    @TableField(value = "METHOD_NAME")
    private String methodName;

    /**
     * 是否成功 -1 失败 1 成功
     */
    @TableField(value = "SUCCEED")
    private int succeed;

    /**
     * IP
     */
    @TableField(value = "IP")
    private String ip;

    /**
     * 描述
     */
    @TableField(value = "MESSAGE")
    private String message;

    /**
     * 浏览器
     */
    @TableField(value = "BROWSER")
    private String browser;

    /**
     * 系统
     */
    @TableField(value = "OS")
    private String os;

    /**
     * 是否是移动端 1 移动端 2 PC端
     */
    @TableField(value = "IS_MOBILE")
    private Integer isMobile;

    /**
     * 参数
     */
    @TableField(value = "PARAMS")
    private String params;

    /**
     * 请求URI
     */
    @TableField(value = "REQUEST_URI")
    private String requestUri;

    /**
     * 操作方式
     */
    @TableField(value = "METHOD")
    private String method;

    /**
     * 执行时间
     */
    @TableField(value = "TIME")
    private Long time;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}