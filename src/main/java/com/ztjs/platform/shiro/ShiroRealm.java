package com.ztjs.platform.shiro;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.model.dto.upms.PermissionDto;
import com.ztjs.platform.model.po.upms.RolePo;
import com.ztjs.platform.model.po.upms.UserPo;
import com.ztjs.platform.model.vo.upms.UserToken;
import com.ztjs.platform.service.upms.PermissionService;
import com.ztjs.platform.service.upms.RoleService;
import com.ztjs.platform.service.upms.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户认证和授权
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 14:33
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    /**
     * 授权: 验证权限时调用
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserToken userToken = (UserToken) getAvailablePrincipal(principalCollection);

        // 当前用户所有角色
        Set<String> roles = new HashSet<>();
        RolePo role = roleService.getRoleByUserId(userToken.getId());
        if (!StrUtil.isEmptyIfStr(role)) {
            roles.add(role.getRoleName());
        }

        // 当前用户所有权限
        List<PermissionDto> list = permissionService.getPermissionByUserId(userToken.getId());
        Set<String> permissions = new HashSet<>();
        for (PermissionDto permission : list) {
            if (!StrUtil.isEmptyIfStr(permission.getPermCode())) {
                permissions.add(permission.getPermCode());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        UserPo po = userService.getUserByLoginName(username);

        if (ObjectUtil.isNull(po)) {
            throw new UnknownAccountException();
        }

        if (po.getLocked() == -1) {
            throw new LockedAccountException();
        }

        UserToken userToken = new UserToken();
        userToken.setId(po.getId());
        userToken.setUsername(username);
        userToken.setNickname(po.getNickname());
        userToken.setSalt(po.getSalt());
        userToken.setPassword(po.getPassword());

        return new SimpleAuthenticationInfo(userToken, userToken.getPassword(), getName());
    }

}