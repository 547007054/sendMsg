package com.ztjs.platform.log;

import com.ztjs.platform.model.po.log.OperationLogPo;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:22
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class LogEvent extends ApplicationEvent {

    private OperationLogPo logPo;

    public LogEvent(Object source, OperationLogPo logPo) {
        super(source);
        this.logPo = logPo;
    }

}