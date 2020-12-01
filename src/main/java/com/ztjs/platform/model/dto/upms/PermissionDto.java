package com.ztjs.platform.model.dto.upms;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限 DTO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:47
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class PermissionDto implements Serializable {

    private static final long serialVersionUID = 7049234440640028508L;

    /**
     * 权限ID 自增主键
     */
    private Integer id;

    /**
     * 权限父ID
     */
    private Integer parentId;

    /**
     * 权限名称
     */
    private String permName;

    /**
     * 权限编码
     */
    private String permCode;

    /**
     * 排序
     */
    private Integer sort;

}