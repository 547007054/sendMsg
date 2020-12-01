package com.ztjs.platform.controller.upms;

import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.common.constant.CommonConstants;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.common.utils.JwtUtils;
import com.ztjs.platform.log.LogUtils;
import com.ztjs.platform.model.vo.upms.UserToken;
import com.ztjs.platform.service.log.AccountLogService;
import com.ztjs.platform.shiro.utils.ShiroUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户登录 控制器
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:54
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping
public class LoginController {

    private final AccountLogService accountLogService;
    private final RedisTemplate redisTemplate;
    private final EhCacheManager ehCacheManager;

    /**
     * 后台管理登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登录认证
     *
     * @return
     */
    @PostMapping("/loginForm")
    @ResponseBody
    public Result loginForm(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Result result;

        try {
            result = verifyForm(request);
            if (result.isFail()) {
                return result;
            }

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                result.setCode(500);
                result.setMsg("账号不存在！");
                return result;
            } catch (IncorrectCredentialsException e) {
                Cache<String, AtomicInteger> passwordRetryCache = ehCacheManager.getCache("passwordRetryCache");
                if (null != passwordRetryCache) {
                    int retryNum = (passwordRetryCache.get(username) == null ? 0 : passwordRetryCache.get(username)).intValue();
                    if (retryNum > 0 && retryNum < 6) {
                        result.setCode(500);
                        result.setMsg("用户名或密码错误" + retryNum + "次,再输错" + (6 - retryNum) + "次账号将锁定");
                        accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "用户名或密码错误" + retryNum + "次,再输错" + (6 - retryNum) + "次账号将锁定"));
                        return result;
                    }
                }
            } catch (LockedAccountException e) {
                result.setCode(500);
                result.setMsg("账号锁定，请联系管理员！");
                accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "账号锁定"));
                return result;
            } catch (ExcessiveAttemptsException e) {
                result.setCode(500);
                result.setMsg("用户名或密码错误次数大于5次,账户已锁定！");
                accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "用户名或密码错误次数大于5次,账户已锁定"));
                return result;
            } catch (Exception e) {
                result.setCode(500);
                result.setMsg("用户登录失败，请您稍后再试！");
                accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "登录失败"));
                return result;
            } finally {
                token.clear();
            }
        } catch (Exception e) {
            result = new Result();
            result.setCode(500);
            result.setMsg("系统繁忙, 请稍后再试！");
            accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "登录失败"));
            e.printStackTrace();
        }

        Integer duration = 60 * 60 * 60 * 24 * 1000;
        String userToken = JwtUtils.buildJwt(username, username, duration);
        redisTemplate.opsForValue().set("user:token:manage:" + username, userToken, duration, TimeUnit.MILLISECONDS);
        Map<String, Object> resultMap = new HashMap<>(3);
        resultMap.put("nickname", ShiroUtils.getUser().getNickname());
        resultMap.put("username", username);
        resultMap.put("token", userToken);
        result.setData(resultMap);

        result.setCode(200);
        result.setMsg("用户通过认证！");
        accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "登录成功"));
        return result;
    }

    /**
     * 用户登出
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        UserToken userToken = ShiroUtils.getUser();
        String key = "user:token:manage:" + userToken.getUsername();
        redisTemplate.delete(key);

        key = "shiro:cache:shiro-activeSessionCache:" + userToken.getUsername();
        redisTemplate.delete(key);

        ShiroUtils.logout();
        accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Logout", userToken.getUsername(), "登出成功"));
        return "redirect:login";
    }

    /**
     * 验证参数是否正确
     *
     * @param request
     * @return
     */
    private Result verifyForm(HttpServletRequest request) {
        Result result = new Result();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String kaptcha = request.getParameter("kaptcha");
        String randomStr = request.getParameter("randomStr");

        if (StrUtil.isEmptyIfStr(username)) {
            result.setCode(500);
            result.setMsg("账号不能为空！");
            return result;
        }

        if (StrUtil.isEmptyIfStr(password)) {
            result.setCode(500);
            result.setMsg("密码不能为空！");
            return result;
        }

        if (StrUtil.isEmptyIfStr(kaptcha)) {
            result.setCode(500);
            result.setMsg("验证码不能为空！");
            return result;
        }

        String code = (String) redisTemplate.opsForValue().get(CommonConstants.DEFAULT_CODE_KEY + randomStr);
        if (StrUtil.isEmptyIfStr(code)) {
            result.setCode(500);
            result.setMsg("验证码不合法！");
            accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "验证码不合法"));
            return result;
        }

        if (!StrUtil.equals(kaptcha, code)) {
            result.setCode(500);
            result.setMsg("验证码不合法！");
            accountLogService.saveAccountLogPo(LogUtils.getAccountLogPo("Login", username, "验证码不合法"));
            return result;
        }

        result.setCode(200);
        return result;
    }

}