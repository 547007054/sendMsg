package com.ztjs.platform.model.po.upms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

/**
 * 用户 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 14:56
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_user")
public class UserPo implements Serializable {

    private static final long serialVersionUID = 5669575757125079103L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    @TableField(value = "NICKNAME")
    private String nickname;

    /**
     * 性别 1 男  2 女
     */
    @TableField(value = "SEX")
    private Integer sex;

    /**
     * 出生日期
     */
    @TableField(value = "BIRTHDAY")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    /**
     * 身份证号
     */
    @TableField(value = "ID_CARD")
    private String idCard;

    /**
     * 民族
     */
    @TableField(value = "NATION")
    private String nation;

    /**
     * 籍贯
     */
    @TableField(value = "NATIVE_PLACE")
    private String nativePlace;

    /**
     * 手机号码
     */
    @TableField(value = "PHONE")
    private String phone;

    /**
     * 职务ID 对应职务表
     */
    @TableField(value = "DUTY_ID")
    private Integer dutyId;

    /**
     * 部门ID 对应部门表
     */
    @TableField(value = "DEPARTMENT_ID")
    private Integer departmentId;

    /**
     * 是否时管理员 1 是  -1 不是
     */
    @TableField(value = "IS_ADMIN")
    private Integer isAdmin;

    /**
     * 是否显示大屏 1 显示  -1 不显示
     */
    @TableField(value = "IS_HOME")
    private Integer isHome;

    /**
     * 登录账号
     */
    @TableField(value = "LOGIN_NAME")
    private String loginName;

    /**
     * 登录密码
     */
    @TableField(value = "PASSWORD")
    private String password;

    /**
     * 加密字符串
     */
    @TableField(value = "SALT")
    private String salt;

    /**
     * 用户头像
     */
    @TableField(value = "AVATAR")
    private String avatar;

    /**
     * 是否锁定账号 -1 锁定 1 正常
     */
    @TableField(value = "LOCKED")
    private Integer locked;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}