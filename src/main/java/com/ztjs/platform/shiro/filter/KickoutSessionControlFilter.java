package com.ztjs.platform.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.vo.upms.UserToken;
import com.ztjs.platform.shiro.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 自定义过滤器，进行用户访问控制
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:26
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
public class KickoutSessionControlFilter extends AccessControlFilter {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private final static String KICKOUT = "kickout";

    /**
     * 踢出后到的地址
     */
    private String kickoutUrl;

    /**
     * 踢出之前登录的/之后登录的用户 默认false踢出之前登录的用户
     */
    private boolean kickoutAfter = false;

    /**
     * 同一个帐号最大会话数 默认1
     */
    private int maxSession = 1;
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /**
     * 设置Cache的key的前缀
     *
     * @param cacheManager
     */
    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-activeSessionCache");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        // 没有登录授权 且没有记住我
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            Result result = new Result();
            if (ShiroUtils.isAjax(request)) {
                result.setCode(500);
                result.setMsg("您已在别处登录，请您修改密码或重新登录");
                out(response, result);
                return false;
            } else {
                return true;
            }
        }

        Session session = subject.getSession();
        try {
            UserToken user = (UserToken) subject.getPrincipal();
            String username = user.getUsername();
            Serializable sessionId = session.getId();
            Deque<Serializable> deque = cache.get(username);

            if (deque == null) {
                deque = new ArrayDeque<>();
            }

            // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
            if (!deque.contains(sessionId) && session.getAttribute(KICKOUT) == null) {
                deque.push(sessionId);
                cache.put(username, deque);
            }

            // 如果队列里的sessionId数超出最大会话数，开始踢人
            while (deque.size() > maxSession) {
                Serializable kickoutSessionId = kickoutAfter ? deque.removeFirst() : deque.removeLast();
                cache.put(username, deque);

                try {
                    Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
                    if (kickoutSession != null) {
                        kickoutSession.setAttribute(KICKOUT, true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (session.getAttribute(KICKOUT) != null && (Boolean) session.getAttribute(KICKOUT) == true) {
                try {
                    subject.logout();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                saveRequest(request);
                return isAjaxResponse(request, response);
            }
            return true;
        } catch (Exception e) {
            return isAjaxResponse(request, response);
        }
    }

    /**
     * Response 输出 Json
     *
     * @param response
     * @param result
     */
    public static void out(ServletResponse response, Result result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(objectMapper.writeValueAsString(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 判断是否已经踢出
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    private boolean isAjaxResponse(ServletRequest request, ServletResponse response) throws IOException {
        Result result = new Result();
        if (ShiroUtils.isAjax(request)) {
            log.info(getClass().getName() + "当前用户已经在其他地方登录，并且是Ajax请求！");
            result.setCode(500);
            result.setMsg("您已在别处登录，请您修改密码或重新登录");
            out(response, result);
        } else {
            WebUtils.issueRedirect(request, response, kickoutUrl);
        }
        return false;
    }

}