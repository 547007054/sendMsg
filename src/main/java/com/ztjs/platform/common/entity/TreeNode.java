package com.ztjs.platform.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:20
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class TreeNode implements Serializable {

    private static final long serialVersionUID = -8603714321827788913L;

    private String id;

    private String parentId;

    private String title;

}