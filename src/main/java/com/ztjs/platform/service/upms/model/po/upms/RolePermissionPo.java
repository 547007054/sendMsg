package com.ztjs.platform.service.upms.model.po.upms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:03
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_role_permission")
public class RolePermissionPo implements Serializable {

    private static final long serialVersionUID = 4597586761647259351L;

    /**
     * ID 自增主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    @TableField(value = "ROLE_ID")
    private Integer roleId;

    /**
     * 权限ID
     */
    @TableField(value = "PERMISSION_ID")
    private Integer permissionId;

}