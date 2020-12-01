package com.ztjs.platform.model.po.push;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/8/21
 * @Version: v1.0
 */

@Data
@TableName(value = "LaLo")
public class TechnologyPo implements Serializable {

    private static final long serialVersionUID = 607335639502560385L;


    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "WE_CHAT_ID")
    private String openid;

    /**
     * 组号
     */
    @TableField(value = "GROUP_ID")
    private String groupId;

    /**
     * 手机号
     */
    @TableField(value = "PHONE_NUMBER")
    private String phoneNumber;

    /**
     * 经度
     */
    @TableField(value = "LONGITUDE")
    private String longitude;

    /**
     * 纬度
     */
    @TableField(value = "LATITUDE")
    private String latitude;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    private Timestamp createTime;
}
