package com.ztjs.platform.shiro.matcher;

import com.ztjs.platform.model.vo.upms.UserToken;
import com.ztjs.platform.shiro.utils.ShiroUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.util.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 输错5次密码锁定2分钟
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:28
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public class PasswordHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public PasswordHashedCredentialsMatcher(EhCacheManager ehCacheManager) {
        passwordRetryCache = ehCacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取用户名
        String username = (String) token.getPrincipal();
        UserToken userToken = (UserToken) info.getPrincipals().getPrimaryPrincipal();

        //获取用户登录次数
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (StringUtils.isEmpty(retryCount)) {
            //如果用户没有登陆过,登陆次数加1 并放入缓存
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }

        if (retryCount.incrementAndGet() > 5) {
            throw new ExcessiveAttemptsException();
        }

        String credentials = String.valueOf((char[]) token.getCredentials());
        String encrypted = ShiroUtils.entryptPassword(credentials, userToken.getSalt());

        if (userToken.getPassword().equals(encrypted)) {
            //如果正确,从缓存中将用户登录计数 清除
            passwordRetryCache.remove(username);
            return true;
        }
        return false;
    }

}