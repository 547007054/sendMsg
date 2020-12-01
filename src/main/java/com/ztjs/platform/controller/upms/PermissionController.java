package com.ztjs.platform.controller.upms;


import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.common.entity.PageInfo;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.dto.upms.PermTreeDto;
import com.ztjs.platform.model.dto.upms.PermissionDto;
import com.ztjs.platform.model.po.upms.PermissionPo;
import com.ztjs.platform.service.upms.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 权限设置
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
@RequestMapping("upms/permission")
public class PermissionController {
    private final PermissionService permissionService;
    @GetMapping
    public String index() {
        return "upms/permission";
    }

    @GetMapping(value = "/getPermissionByPid")
    public @ResponseBody
    Result<PageInfo<PermissionDto>> getPermissionByPid(HttpServletRequest request) {
        Result<PageInfo<PermissionDto>> result = new Result<>();
        try {
            String pid = request.getParameter("pid");
            if (StrUtil.isEmptyIfStr(pid)) {
                return null;
            }

            List<PermissionDto> list = permissionService.getPermissionByPid(Integer.valueOf(pid));
            if (StrUtil.isEmptyIfStr(list)) {
                return null;
            }

            PageInfo<PermissionDto> pageInfo = new PageInfo<>();
            pageInfo.setTotal(list.size());
            pageInfo.setRows(list);

            result.setData(pageInfo);
            result.setCode(200);
            result.setMsg("操作成功！");
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
            e.printStackTrace();
        }
        return result;
    }


    @GetMapping(value = "/getAllPermission")
    public @ResponseBody
    Result<List<PermTreeDto>> getAllPermission() {
        Result<List<PermTreeDto>> result = new Result<>();
        try {
            List<PermTreeDto> list = permissionService.getAllPermission();
            System.out.print(list);
            for (PermTreeDto dto : list) {
                if (!StrUtil.isEmptyIfStr(dto.getPermCode())) {
                    dto.setPermName(dto.getPermName() + " " + dto.getPermCode());
                }
            }
            result.setData(list);
            result.setCode(200);
            result.setMsg("操作成功！");
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/addPermission")
    public @ResponseBody
    Result addPermission(@RequestBody PermissionDto dto) {
        Result result = new Result();
        try {
            PermissionPo po = new PermissionPo();
            po.setParentId(dto.getParentId());
            po.setPermName(dto.getPermName());
            po.setPermType("P");
            po.setPermCode(dto.getPermCode());
            po.setSort(dto.getSort());
            po.setCreateTime(new Timestamp(new Date().getTime()));
            boolean flag = permissionService.addPermission(po);
            if (!flag) {
                result.setMsg("操作失败！");
                result.setCode(500);
                return result;
            }
            result.setCode(200);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }


    @PostMapping(value = "/updatePermission")
    public @ResponseBody
    Result updatePermission(@RequestBody PermissionDto dto) {
        Result result = new Result();
        try {
            PermissionPo po = permissionService.getById(dto.getId());
            po.setPermName(dto.getPermName());
            po.setPermCode(dto.getPermCode());
            po.setSort(dto.getSort());
            po.setCreateTime(new Timestamp(new Date().getTime()));
            boolean flag = permissionService.updatePermission(po);
            if (!flag) {
                result.setMsg("操作失败！");
                result.setCode(500);
                return result;
            }
            result.setCode(200);
            result.setMsg("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }


    @GetMapping(value = "/deletePermissionById/{id}")
    public @ResponseBody
    Result deletePermissionById(@PathVariable("id") Integer id) {
        Result result = new Result();
        try {
            boolean flag = permissionService.deletePermissionById(id);
            if (!flag) {
                result.setCode(500);
                result.setMsg("删除失败！");
                return result;
            }

            result.setCode(200);
            result.setMsg("操作成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
        }
        return result;
    }

}