package com.ztjs.platform.model.po.fence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 电子围栏 PO 实体类
 */
@Data
@TableName(value = "LaLo")
public class PersonPo implements Serializable {

    private static final long serialVersionUID = 607335639502560385L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 手机号
     */
    @TableField(value = "PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 组号
     */
    @TableField(value = "GROUP_ID")
    private String groupId;

    /**
     * 经度列
     */
    @TableField(value = "LONGITUDE")
    private String longitude;

    /**
     * 纬度列
     */
    @TableField(value = "LATITUDE")
    private String latitude;

    /**
     * 用户的微信openId
     */
    @TableField(value = "WE_CHAT_ID")
    private String weChatId;

    /**
     * 用户的标识（便于查看是否已经发送消息）
     */
    @TableField(value = "FLAG")
    private int flag;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
    /**
     * 消息类型
     */
    @TableField(value = "TYPE")
    private String type;


}