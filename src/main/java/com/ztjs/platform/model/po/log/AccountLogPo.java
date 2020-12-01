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
 * 用户登录、登出日志 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 17:54
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_account_log")
public class AccountLogPo implements Serializable {

    private static final long serialVersionUID = -3724831276963743124L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 日志记录名称
     */
    @TableField(value = "LOG_NAME")
    private String logName;

    /**
     * 账号信息
     */
    @TableField(value = "ACCOUNT_NAME")
    private String accountName;

    /**
     * 是否执行成功(0失败1成功)
     */
    @TableField(value = "SUCCEED")
    private Integer succeed;

    /**
     * 具体消息
     */
    @TableField(value = "MESSAGE")
    private String message;

    /**
     * 登录 IP
     */
    @TableField(value = "IP")
    private String ip;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}