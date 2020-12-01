package com.ztjs.platform.model.po.upms;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目角色
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:08
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project_user")
public class ProjectUserPo implements Serializable {

    private static final long serialVersionUID = 3985891202197242813L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目ID 对应项目表
     */
    @TableField(value = "PROJECT_ID")
    private Integer projectId;

    /**
     * 用户ID 对应用户表
     */
    @TableField(value = "USER_ID")
    private Integer userId;

}