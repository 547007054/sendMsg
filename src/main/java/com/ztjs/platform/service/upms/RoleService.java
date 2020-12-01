package com.ztjs.platform.service.upms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.common.entity.PageInfo;
import com.ztjs.platform.mapper.upms.RoleMapper;
import com.ztjs.platform.model.po.upms.RolePermissionPo;
import com.ztjs.platform.model.po.upms.RolePo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 角色 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:12
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "ztjs:upms:role")
@Transactional(rollbackFor = Exception.class)
public class RoleService extends ServiceImpl<RoleMapper, RolePo> {

    private final RolePermissionService rolePermissionService;
    /**
     * 根据用户ID获取角色信息
     *
     * @param userId
     * @return
     */
    public RolePo getRoleByUserId(Integer userId) {
        return this.baseMapper.getRoleByUserId(userId);
    }

    /**
     * 获取所有的角色信息
     *
     * @param params
     * @return
     */
    public PageInfo<RolePo> getAllRole(Map<String, Object> params) {
       /* QueryWrapper<RolePo> queryWrapper = new QueryWrapper<>();*/

        /*if (!StrUtil.isEmptyIfStr(params.get("keyword"))) {
            queryWrapper.like("ROLE_NAME", params.get("keyword"));
            queryWrapper.or().like("ROLE_TYPE", params.get("keyword"));
            queryWrapper.or().like("DESCRIPTION", params.get("keyword"));
            queryWrapper.or().like("CREATE_TIME", params.get("keyword"));
        }*/

        Integer pageNo = Integer.valueOf(params.get("pageNo").toString());
        Integer pageSize = Integer.valueOf(params.get("pageSize").toString());
        IPage<RolePo> iPage = this.baseMapper.getAllRole(new Page<>(pageNo, pageSize), params);

        PageInfo<RolePo> pageInfo = new PageInfo<>();
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(iPage.getTotal());
        pageInfo.setRows(iPage.getRecords());
        return pageInfo;
    }

    /**
     * 添加角色信息
     *
     * @param po
     * @return
     */
    public Boolean addRole(RolePo po) {
        return this.baseMapper.insert(po) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 修改角色信息
     *
     * @param po
     * @return
     */
    public Boolean updateRole(RolePo po) {
        return this.baseMapper.updateById(po) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 根据ID删除角色信息
     *
     * @param id
     * @return
     */
    public boolean deleteRoleById(Integer id) {
        try {
            QueryWrapper<RolePermissionPo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(RolePermissionPo::getPermissionId, id);
            this.rolePermissionService.remove(queryWrapper);
            this.baseMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    /**
     * 根据角色ID授权
     *
     * @param roleId
     * @param permissionIds
     * @return
     */
    public boolean roleAuthorization(Integer roleId, String permissionIds) {
        try {
            QueryWrapper<RolePermissionPo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(RolePermissionPo::getRoleId, roleId);
            rolePermissionService.remove(queryWrapper);

            String[] ids = permissionIds.split(",");
            List<RolePermissionPo> list = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                RolePermissionPo po = new RolePermissionPo();
                po.setRoleId(roleId);
                po.setPermissionId(Integer.valueOf(ids[i]));
                list.add(po);
            }
            rolePermissionService.saveBatch(list);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


}