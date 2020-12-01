package com.ztjs.platform.service.log;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.log.AccountLogMapper;
import com.ztjs.platform.model.po.log.AccountLogPo;
import org.springframework.stereotype.Service;

/**
 * 用户登录、登出日志 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:04
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
public class AccountLogService extends ServiceImpl<AccountLogMapper, AccountLogPo> {

    /**
     * 保存用户登录、登出日志
     *
     * @param po
     * @return
     */
    public int saveAccountLogPo(AccountLogPo po) {
        return this.baseMapper.insert(po);
    }

}