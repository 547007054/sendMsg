package com.ztjs.platform.model.po.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 项目 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:20
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project")
public class ProjectPo implements Serializable {

    private static final long serialVersionUID = 8816572886711064470L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目父ID
     */
    @TableField(value = "PARENT_ID")
    private Integer parentId;

    /**
     * 承建部门 关联部门ID
     */
    @TableField(value = "DEPARTMENT_ID")
    private Integer departmentId;

    /**
     * 项目名称
     */
    @TableField(value = "PROJECT_NAME")
    private String projectName;

    /**
     * 项目部组织架构图 路径
     */
    @TableField(value = "ORGANIZATION_PIC")
    private String organizationPic;

    /**
     * 工程视频路径
     */
    @TableField(value = "ENGINEERING_VIDEO")
    private String engineeringVideo;

    /**
     * 合同路径
     */
    @TableField(value = "AGREEMENT")
    private String agreement;

    /**
     * 项目概况
     */
    @TableField(value = "DESCRIPTION")
    private String description;

    /**
     * 项目部所在经度
     */
    @TableField(value = "LNG")
    private String lng;

    /**
     * 项目部所在纬度
     */
    @TableField(value = "LAT")
    private String lat;

    /**
     * 项目部所在城市 方便调用天气预报接口
     */
    @TableField(value = "CITY")
    private String city;

    /**
     * 项目部所在地
     */
    @TableField(value = "PROJECT_ADDRESS")
    private String projectAddress;

    /**
     * 项目状态 1 在建  2 完工
     */
    @TableField(value = "STATUS")
    private Integer status;

    /**
     * 开始时间
     */
    @TableField(value = "START_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField(value = "END_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    /**
     * 建筑面积
     */
    @TableField(value = "FLOORAGE")
    private Double floorage;

    /**
     * 结构类别
     */
    @TableField(value = "STRUCTURE_TYPE")
    private String structureType;

    /**
     * 电气设计 填写施工单位
     */
    @TableField(value = "ELECTRIC_DESIGN")
    private String electricDesign;

    /**
     * 水暖通风设计 填写施工单位
     */
    @TableField(value = "PLUMBING_DESIGN")
    private String plumbingDesign;

    /**
     * 项目排序
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