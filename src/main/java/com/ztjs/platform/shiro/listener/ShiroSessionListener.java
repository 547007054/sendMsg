package com.ztjs.platform.shiro.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:28
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    /**
     * 会话创建时触发
     *
     * @param session
     */
    @Override
    public void onStart(Session session) {
        log.debug("会话创建：" + session.getId());
        sessionCount.incrementAndGet();
    }

    /**
     * 退出时触发
     *
     * @param session
     */
    @Override
    public void onStop(Session session) {
        log.info("会话停止：" + session.getId());
        sessionCount.decrementAndGet();
    }

    /**
     * 会话过期时触发
     *
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        log.debug("会话过期：" + session.getId());
        sessionCount.decrementAndGet();
    }

}