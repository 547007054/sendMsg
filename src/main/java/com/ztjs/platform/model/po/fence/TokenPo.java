package com.ztjs.platform.model.po.fence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 动态存取token值
 */

@Data
@TableName(value = "Token")
public class TokenPo implements Serializable {
    private static final long serialVersionUID = 607335639502560385L;

    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * token值
     */
    @TableField(value = "TOKEN")
    private String token;

}