package com.ztjs.platform.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 统一错误处理 控制器
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:52
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Controller
@Scope("prototype")
public class ErrorPageController {

    @GetMapping("/404")
    public String error404() {
        return "error/404";
    }

    @GetMapping("/500")
    public String error500() {
        return "error/500";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

}