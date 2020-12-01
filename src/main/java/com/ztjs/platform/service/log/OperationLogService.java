package com.ztjs.platform.service.log;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.mapper.log.OperationLogMapper;
import com.ztjs.platform.model.po.log.OperationLogPo;
import org.springframework.stereotype.Service;

/**
 * 用户操作日志 服务实现类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:05
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Service
public class OperationLogService extends ServiceImpl<OperationLogMapper, OperationLogPo> {

    /**
     * 保存用户操作日志
     *
     * @param po
     * @return
     */
    public int saveOperationLog(OperationLogPo po) {
        return this.baseMapper.insert(po);
    }

}