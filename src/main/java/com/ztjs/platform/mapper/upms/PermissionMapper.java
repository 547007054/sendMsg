package com.ztjs.platform.mapper.upms;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ztjs.platform.model.dto.upms.MenuDto;
import com.ztjs.platform.model.dto.upms.PermTreeDto;
import com.ztjs.platform.model.dto.upms.PermissionDto;
import com.ztjs.platform.model.po.upms.PermissionPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限 Mapper 接口
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 17:20
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public interface PermissionMapper extends BaseMapper<PermissionPo> {

    /**
     * 根据用户ID获取菜单信息列表
     *
     * @param userId
     * @return
     */
    List<MenuDto> getMenuByUserId(@Param("userId") Integer userId);

    /**
     * 获取所有的权限信息列表
     *
     * @return
     */
    List<PermTreeDto> getAllPermission();

    /**
     * 获取所有得菜单信息列表
     *
     * @return
     */
    List<MenuDto> getAllMenu();

    /**
     * 根据用户ID获取权限信息列表
     *
     * @param userId
     * @return
     */
    List<PermissionDto> getPermissionByUserId(@Param("userId") Integer userId);

    /**
     * 根据权限PID获取权限信息列表
     *
     * @param pid
     * @return
     */
    List<PermissionDto> getPermissionByPid(@Param("pid") Integer pid);
}