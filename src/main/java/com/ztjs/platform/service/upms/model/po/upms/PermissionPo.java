package com.ztjs.platform.service.upms.model.po.upms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 权限 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 15:56
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_permission")
public class PermissionPo implements Serializable {

    private static final long serialVersionUID = 2173532684506729247L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限父ID
     */
    @TableField(value = "PARENT_ID")
    private Integer parentId;

    /**
     * 权限名称
     */
    @TableField(value = "PERM_NAME")
    private String permName;

    /**
     * 权限类型 M 菜单 P 权限
     */
    @TableField(value = "PERM_TYPE")
    private String permType;

    /**
     * 权限编码
     */
    @TableField(value = "PERM_CODE")
    private String permCode;

    /**
     * 菜单路径
     */
    @TableField(value = "MENU_URL")
    private String menuUrl;

    /**
     * 菜单图标
     */
    @TableField(value = "MENU_ICON")
    private String menuIcon;

    /**
     * 排序
     */
    @TableField(value = "SORT")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}