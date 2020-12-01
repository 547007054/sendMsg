package com.ztjs.platform.service.upms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.upms.RolePermissionMapper;
import com.ztjs.platform.model.po.upms.RolePermissionPo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:12
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, RolePermissionPo> {

    /**
     * 根据权限ID 获取权限角色列表信息
     *
     * @param permissionId
     * @return
     */
    public List<RolePermissionPo> getRolePermissionByPermissionById(Integer permissionId) {
        QueryWrapper<RolePermissionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePermissionPo::getPermissionId, permissionId);
        return this.baseMapper.selectList(queryWrapper);
    }

    /**
     * 根据角色ID 获取权限角色列表信息
     *
     * @param roleId
     * @return
     */
    public List<RolePermissionPo> getRolePermissionByRoleId(Integer roleId) {
        QueryWrapper<RolePermissionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePermissionPo::getRoleId, roleId);
        return this.baseMapper.selectList(queryWrapper);
    }

}