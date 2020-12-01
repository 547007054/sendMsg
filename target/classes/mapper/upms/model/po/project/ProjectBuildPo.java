package com.ztjs.platform.model.po.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目参与建设单位 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:40
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project_build")
public class ProjectBuildPo implements Serializable {

    /**
     * 主键ID 对应项目表中项目ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    /**
     * 建设单位
     */
    @TableField(value = "BUILD_UNIT")
    private String buildUnit;

    /**
     * 设计单位
     */
    @TableField(value = "DESIGN_UNIT")
    private String designUnit;

    /**
     * 施工单位
     */
    @TableField(value = "CONSTRUCTION_UNIT")
    private String constructionUnit;

    /**
     * 监理单位
     */
    @TableField(value = "SUPERVISOR_UNIT")
    private String supervisorUnit;

    /**
     * 勘查单位
     */
    @TableField(value = "PROSPECTING_UNIT")
    private String prospectingUnit;

}