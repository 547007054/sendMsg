package com.ztjs.platform.model.po.fence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 电子围栏 PO 实体类
 */
@Data
@TableName(value = "YueRong_fence")
public class FencePo implements Serializable {

    private static final long serialVersionUID = 607335639502560385L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 区域名称
     */
    @TableField(value = "FENCE_NAME")
    private String fenceName;
    /**
     * 经度列
     */
    @TableField(value = "LONGITUDE_COLUMN")
    private String longitudeColumn;

    /**
     * 纬度列
     */
    @TableField(value = "LATITUDE_COLUMNS")
    private String latitudeColumns;

}