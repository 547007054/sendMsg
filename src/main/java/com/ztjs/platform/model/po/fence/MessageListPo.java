package com.ztjs.platform.model.po.fence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;

/**
 * Created by Lenovo on 2019/9/11.
 * 信息表格导入
 */
@Data
@TableName(value = "YueRong_Message")
public class MessageListPo {

    private static final long serialVersionUID = 607335639502560385L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 日期
     */
    @TableField(value = "PUSH_TIME")
    private String time;

    /**
     * 推送内容
     */
    @TableField(value = "CRAFT_CONTENT")
    private String craftContent;

    /**
     * 导入时间
     */
    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 区域名称
     */
    @TableField(value = "FENCE_NAME")
    private String name;

}

