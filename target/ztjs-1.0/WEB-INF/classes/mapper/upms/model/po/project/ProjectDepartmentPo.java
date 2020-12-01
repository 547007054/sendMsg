package com.ztjs.platform.model.po.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目主管部门 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:51
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project_department")
public class ProjectDepartmentPo implements Serializable {

    private static final long serialVersionUID = -8445950238128829379L;

    /**
     * 主键ID 对应项目表中项目ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    /**
     * 部门ID 对应部门表
     */
    @TableField(value = "DEPARTMENT_ID")
    private Integer departmentId;

    /**
     * 用户ID 对应用户表
     */
    @TableField(value = "USER_ID")
    private Integer userId;

}