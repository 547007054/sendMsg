package com.ztjs.platform.model.po.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目工程图纸 PO 实体图
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/8 17:03
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
@TableName(value = "hk_project_engineering_pic")
public class ProjectEngineeringPic implements Serializable {

    private static final long serialVersionUID = -8864801545972493713L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片名
     */
    @TableField(value = "PIC_NAME")
    private String picName;

    /**
     * 图片大小
     */
    @TableField(value = "PIC_SIZE")
    private Double picSize;

    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

}