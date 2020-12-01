package com.ztjs.platform.model.po.upms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:02
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_user_role")
public class UserRolePo implements Serializable {

    private static final long serialVersionUID = 9015445715473828406L;

    /**
     * ID 自增主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID 对应用户表
     */
    @TableField(value = "USER_ID")
    private Integer userId;

    /**
     * 角色ID 对应角色表
     */
    @TableField(value = "ROLE_ID")
    private Integer roleId;

}