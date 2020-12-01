package com.ztjs.platform.model.po.push;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/8/21
 * @Version: v1.0
 */

@Data
@TableName(value = "groups")
public class GroupPo implements Serializable {

    private static final long serialVersionUID = 607335639502560385L;


    /**
     * 自增主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 组号
     */
    @TableField(value = "GROUP_ID")
    private String groupId;

    /**
     * 组名
     */
    @TableField(value = "PhoneNo")
    private String phoneNo;

}
