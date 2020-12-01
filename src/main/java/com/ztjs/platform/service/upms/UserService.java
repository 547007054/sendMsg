package com.ztjs.platform.service.upms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.upms.UserMapper;
import com.ztjs.platform.model.po.upms.UserPo;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:13
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "ztjs:upms:user")
@Transactional(rollbackFor = Exception.class)
public class UserService extends ServiceImpl<UserMapper, UserPo> {

    /**
     * 根据账号获取用户信息
     *
     * @param loginName
     * @return
     */
    @Cacheable(key = "#username", unless = "#result == null")
    public UserPo getUserByLoginName(String loginName) {
        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserPo::getLoginName, loginName);
        return this.baseMapper.selectOne(queryWrapper);
    }

}