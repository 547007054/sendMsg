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
 * 部门 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:04
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_department")
public class DepartmentPo implements Serializable {

    private static final long serialVersionUID = -5640790159514238939L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门父ID
     */
    @TableField(value = "PARENT_ID")
    private Integer parentId;

    /**
     * 部门名称
     */
    @TableField(value = "DEPARTMENT_NAME")
    private String departmentName;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}