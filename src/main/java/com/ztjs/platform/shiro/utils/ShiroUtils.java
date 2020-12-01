package com.ztjs.platform.shiro.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.common.security.Digests;
import com.ztjs.platform.common.security.Encodes;
import com.ztjs.platform.model.vo.upms.UserToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * Shiro 常用工具类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:29
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
public class ShiroUtils {

    @Autowired
    private static DefaultWebSessionManager sessionManager;

    @Autowired
    private static RedisSessionDAO redisSessionDAO;

    private final static ObjectMapper objectMapper = new ObjectMapper();

    private static final int HASH = 1024;

    /**
     * 获取当前用户Session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 从当前用户Session里面取值
     *
     * @param key
     * @return
     */
    public static Object getValSession(Object key) {
        return getSession().getAttribute(key);
    }

    /**
     * 把值写入当前用户Session里面
     *
     * @param key
     * @param val
     */
    public static void setValSession(Object key, Object val) {
        getSession().setAttribute(key, val);
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     *
     * @param plaintext 明文
     * @param salt      加密盐
     * @return
     */
    public static String entryptPassword(String plaintext, String salt) {
        try {
            byte[] hashPassword = Digests.sha1(plaintext.getBytes(), Encodes.decodeHex(salt), HASH);
            return Encodes.encodeHex(hashPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 退出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 判断是否登录
     *
     * @return
     */
    public static boolean isLogin() {
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前用户ID
     *
     * @return
     */
    public static Integer getUserId() {
        return getUser() == null ? null : getUser().getId();
    }

    /**
     * 获取 当前登录用户名
     *
     * @return
     */
    public static String getUsername() {
        return getUser() == null ? null : getUser().getUsername();
    }

    /**
     * 获取当前登录得用户User对象
     *
     * @return
     */
    public static UserToken getUser() {
        final UserToken userToken = (UserToken) SecurityUtils.getSubject().getPrincipal();
        return userToken;
    }

    /**
     * 获取活跃的SESSION数量
     *
     * @return
     */
    public static int getActiveSessionCount() {
        return redisSessionDAO.getActiveSessions().size();
    }

    /**
     * 获取活跃的SESSION
     *
     * @return
     */
    public static List<Session> getActiveSessions() {
        return Collections.unmodifiableList(Lists.newArrayList(redisSessionDAO.getActiveSessions()));
    }

    /**
     * 强制退出
     *
     * @param sessionId 退出的sessionId
     */
    public static boolean forceLogout(String sessionId) {
        try {
            Session session = sessionManager.getSession(new DefaultSessionKey(sessionId));
            if (session != null) {
                session.setAttribute("shiro_force_logout_attribute", Boolean.TRUE);
            }
            return Boolean.TRUE;
        } catch (UnknownSessionException e) {
            log.warn(e.getMessage());
        }
        return Boolean.FALSE;
    }

    /**
     * 判断请求是否是ajax
     *
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request) {
        String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
        if ("XMLHttpRequest".equalsIgnoreCase(header)) {
            log.debug("shiro工具类【wyait-manager-->ShiroFilterUtils.isAjax】当前请求,为Ajax请求");
            return Boolean.TRUE;
        }
        log.debug("shiro工具类【wyait-manager-->ShiroFilterUtils.isAjax】当前请求,非Ajax请求");
        return Boolean.FALSE;
    }

    /**
     * Response 输出 Json
     *
     * @param response
     * @param result
     */
    public static void out(HttpServletResponse response, Result result) {
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

}