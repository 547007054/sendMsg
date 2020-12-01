package com.ztjs.platform.controller.upms;

import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.common.entity.PageInfo;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.po.upms.DutyPo;
import com.ztjs.platform.service.upms.DutyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 职务设置 控制器
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/8 18:24
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
//@RequestMapping("fence/indexFence")
public class DutyController {

    private final DutyService dutyService;

    /*@GetMapping
    public String index() {
        return "fence/index";
    }*/

   /* *//**
     * 查询职务信息并展示出来
     *
     * @param request
     * @return
     *//*
    @GetMapping(value = "/getDutyByParams")
    public @ResponseBody
    Result<PageInfo<DutyPo>> getDutyByParams(HttpServletRequest request) {
        Result<PageInfo<DutyPo>> result = new Result<>();
        try {
            String pageNo = request.getParameter("pageNo");
            String pageSize = request.getParameter("pageSize");
            String type = request.getParameter("type");
            String dutyName = request.getParameter("dutyName");

            Map<String, Object> map = new HashMap<>(2);
            map.put("pageNo", pageNo);
            map.put("pageSize", pageSize);

            if (!StrUtil.isEmptyIfStr(type)) {
                map.put("type", type);
            }

            if (!StrUtil.isEmptyIfStr(dutyName)) {
                map.put("dutyName", dutyName);
            }

            PageInfo<DutyPo> pageInfo = dutyService.getDutyByParams(map);
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

    *//**
     * 添加职务信息
     *
     * @param po
     * @return
     *//*
    @PostMapping(value = "/addDuty")
    public @ResponseBody
    Result addDuty(@RequestBody DutyPo po) {
        Result result = new Result();
        try {
            if (StrUtil.isEmptyIfStr(dutyService.addDuty(po))) {
                result.setCode(500);
                result.setMsg("操作失败！");
                return result;
            }
            result.setCode(200);
            result.setMsg("操作成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }

    *//**
     * 删除职务信息
     *
     * @param id
     * @return
     *//*
    @RequestMapping(value = "/deleteDutyById/{id}")
    public @ResponseBody
    Result deleteDutyById(@PathVariable("id") Integer id) {
        Result result = new Result<>();
        try {
            boolean flag = dutyService.deleteDutyById(id);
            if (flag) {
                result.setCode(200);
                result.setMsg("操作成功!");
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }

    *//**
     * 修改一条职务信息
     *
     * @param po
     * @return
     *//*
    @RequestMapping(value = "/updateDuty")
    public @ResponseBody
    Result updateDuty(@RequestBody DutyPo po) {
        Result result = new Result<>();
        try {
            boolean flag = dutyService.updateDuty(po);
            if (flag) {
                result.setCode(200);
                result.setMsg("操作成功！");
            } else {
                result.setMsg("操作失败！");
                result.setCode(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("系统繁忙，请稍后再试！");
            result.setCode(500);
        }
        return result;
    }
*/
}