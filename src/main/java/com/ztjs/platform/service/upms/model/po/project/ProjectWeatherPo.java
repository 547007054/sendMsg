package com.ztjs.platform.service.upms.model.po.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目部天气情况 PO 实体类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 16:55
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project_weather")
public class ProjectWeatherPo implements Serializable {

    /**
     * 主键ID 对应项目表中项目ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;

    /**
     * 今日温度
     */
    @TableField(value = "TEMPERATURE")
    private String temperature;

    /**
     * 今日天气
     */
    @TableField(value = "WEATHER")
    private String weather;

    /**
     * 风向
     */
    @TableField(value = "WIND")
    private String wind;

    /**
     * 接口调用时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}