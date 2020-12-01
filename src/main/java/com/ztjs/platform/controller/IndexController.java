package com.ztjs.platform.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录后根据用户角色信息处理 控制器
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:53
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping
public class IndexController {

    @GetMapping
    public String index() {
        return "redirect:/monitor";
    }

    @GetMapping("index")
    public String index1() {
        return "redirect:/monitor";
    }

    /**
     * 大屏 显示页面
     *
     * @return
     */
    @GetMapping("monitor")
    public String monitor() {
        return "monitor";
    }

    /**
     * 后台管理主页页面
     *
     * @return
     */
    @GetMapping("/wrapMain")
    public String wrapMain() {
        return "wrapMain";
    }

}