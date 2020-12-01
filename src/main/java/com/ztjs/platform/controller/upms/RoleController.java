package com.ztjs.platform.controller.upms;

import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.common.entity.PageInfo;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.po.upms.RolePermissionPo;
import com.ztjs.platform.model.po.upms.RolePo;
import com.ztjs.platform.service.upms.RolePermissionService;
import com.ztjs.platform.service.upms.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色设置
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 张栓
 * @Date: 2019/8/8/008 10:27
 * @Copyright: 北京浩坤科技有限公司
 * @Version: V2.0.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("fence/map")
public class RoleController {

    @GetMapping
    public String index() {
        return "fence/map";
    }

}
