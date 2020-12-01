package com.ztjs.platform.mapper.upms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ztjs.platform.model.po.upms.RolePo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 角色 Mapper 接口
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 17:23
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public interface RoleMapper extends BaseMapper<RolePo> {

    /**
     * 根据用户ID获取角色信息
     * @param userId
     * @return
     */
    RolePo getRoleByUserId(@Param("userId") Integer userId);
    /**
     * 查询角色信息
     * @param
     * @return
     */
    IPage<RolePo> getAllRole(Page page, @Param("params") Map<String, Object> params);
}