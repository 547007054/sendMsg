package com.ztjs.platform.log;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.ztjs.platform.model.po.log.AccountLogPo;
import com.ztjs.platform.model.po.log.OperationLogPo;
import com.ztjs.platform.shiro.utils.ShiroUtils;
import lombok.experimental.UtilityClass;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:21
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@UtilityClass
public class LogUtils {

    public OperationLogPo getOperationLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        String agent = request.getHeader("user-agent");
        UserAgent ua = UserAgentUtil.parse(agent);

        OperationLogPo po = new OperationLogPo();
        po.setLoginName(ShiroUtils.getUsername());
        po.setIp(ServletUtil.getClientIP(request));
        po.setOs(ua.getOs().toString());
        po.setBrowser(ua.getBrowser().toString());
        po.setMethod(request.getMethod());
        po.setParams(HttpUtil.toParams(request.getParameterMap()));
        po.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        po.setIsMobile(ua.isMobile() == true ? 1 : 2);
        po.setCreateTime(DateUtil.date().toTimestamp());
        return po;
    }

    public AccountLogPo getAccountLogPo(String logName, String accountName, String message) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();

        AccountLogPo po = new AccountLogPo();
        po.setLogName(logName);
        po.setAccountName(accountName);
        po.setSucceed(1);
        po.setMessage(message);
        po.setIp(ServletUtil.getClientIP(request));
        po.setCreateTime(DateUtil.date().toTimestamp());
        return po;
    }

}