package com.ztjs.platform.log;

import com.ztjs.platform.model.po.log.OperationLogPo;
import com.ztjs.platform.service.log.OperationLogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步监听日志事件
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:21
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
@Component
@AllArgsConstructor
public class LogListener {

    private final OperationLogService operationLogService;

    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        OperationLogPo po =  event.getLogPo();
        operationLogService.saveOperationLog(po);
    }

}