package com.ztjs.platform.service.upms.model.dto.upms;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单 DTO
 *
 * @Module: 中国铁建华东分公司
 * @Author: 梁声洪
 * @Date: 2019 13:54
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class MenuDto implements Serializable {

    private static final long serialVersionUID = -287200960579044076L;

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
     * 权限路径
     */
    private String menuUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 子菜单
     */
    private List<com.ztjs.platform.model.dto.upms.MenuDto> children = new ArrayList<>();

}