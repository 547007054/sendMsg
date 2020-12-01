package com.ztjs.platform.service.upms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.upms.PermissionMapper;
import com.ztjs.platform.model.dto.upms.MenuDto;
import com.ztjs.platform.model.dto.upms.PermTreeDto;
import com.ztjs.platform.model.dto.upms.PermissionDto;
import com.ztjs.platform.model.po.upms.PermissionPo;
import com.ztjs.platform.model.po.upms.RolePermissionPo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 权限表 服务实现类
 *
 * @Module: 中国铁建华东分公司
 * @Author: 梁声洪
 * @Date: 2019 13:59
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "upms:perm")
@Transactional(rollbackFor = Exception.class)
public class PermissionService extends ServiceImpl<PermissionMapper, PermissionPo> {

    private final RolePermissionService rolePermissionService;

    /**
     * 根据用户ID获取菜单信息列表
     *
     * @param userId
     * @return
     */
    public List<MenuDto> getMenuByUserId(Integer userId) {
        List<MenuDto> list = this.baseMapper.getMenuByUserId(userId);
        return getMenuChildren(list);
    }

    /**
     * 获取所有得菜单信息列表
     *
     * @return
     */
    public List<MenuDto> getAllMenu() {
        return this.baseMapper.getAllMenu();
    }

    /**
     * 获取所有的权限信息列表
     *
     * @return
     */
    public List<PermTreeDto> getAllPermission() {
        return this.baseMapper.getAllPermission();
    }

    /**
     * 根据ID判断是否有子菜单信息
     *
     * @param id
     * @return true 存在  false 不存在
     */
    public boolean isMenuChildrenById(Integer id) {
        QueryWrapper<PermissionPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PermissionPo::getParentId, id).eq(PermissionPo::getPermType, 'F');
        return this.baseMapper.selectCount(queryWrapper) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 根据ID删除菜单信息
     *
     * @param id
     * @return
     */
    public boolean deleteMenuById(Integer id) {
        try {
            QueryWrapper<PermissionPo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(PermissionPo::getParentId, id).eq(PermissionPo::getPermType, 'O');
            List<PermissionPo> list = this.baseMapper.selectList(queryWrapper);

            for (PermissionPo po : list) {
                QueryWrapper<RolePermissionPo> queryWrapper1 = new QueryWrapper<>();
                queryWrapper1.lambda().eq(RolePermissionPo::getPermissionId, po.getId());
                this.rolePermissionService.remove(queryWrapper1);

                this.baseMapper.deleteById(po.getId());
            }

            this.baseMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 根据用户ID获取权限信息列表
     *
     * @param id
     * @return
     */
    public boolean deletePermissionById(Integer id) {
        try {
            QueryWrapper<RolePermissionPo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(RolePermissionPo::getRoleId, id);
            this.rolePermissionService.remove(queryWrapper);

            this.baseMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 根据用户ID获取权限信息列表
     *
     * @param userId
     * @return
     */
    public List<PermissionDto> getPermissionByUserId(Integer userId) {
        return this.baseMapper.getPermissionByUserId(userId);
    }

    /**
     * 修改
     *
     * @param po
     * @return
     */
    public Boolean updatePermission(PermissionPo po) {
        return this.baseMapper.updateById(po) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 添加
     *
     * @param po
     * @return
     */
    public Boolean addPermission(PermissionPo po) {
        return this.baseMapper.insert(po) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 根据权限PID获取权限信息列表
     *
     * @param pid
     * @return
     */
    public List<PermissionDto> getPermissionByPid(Integer pid) {
        return this.baseMapper.getPermissionByPid(pid);
    }

    /**
     * 遍历子菜单
     *
     * @param menuDtoList
     * @return
     */
    private List<MenuDto> getMenuChildren(List<MenuDto> menuDtoList) {
        List<MenuDto> trees = new ArrayList<>();
        for (MenuDto menuDto : menuDtoList) {
            if (menuDto.getParentId() == -1) {
                trees.add(menuDto);
                for (MenuDto dto : menuDtoList) {
                    if (menuDto.getId().equals(dto.getParentId())) {
                        menuDto.getChildren().add(dto);
                    }
                }
            }
        }
        return trees;
    }

}