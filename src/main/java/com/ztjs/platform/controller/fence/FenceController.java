package com.ztjs.platform.controller.fence;

import cn.hutool.core.util.StrUtil;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.model.po.fence.*;
import com.ztjs.platform.service.fence.*;
import com.ztjs.platform.service.send.SendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aa on 2019/8/20.
 */
@Slf4j
@Controller
@Component
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("fence/fence")

public class FenceController {

    private final FenceService fenceService;
    private final SendService sendService;
    private final PersonService personService;
    private final MessageListService messageListService;
    public final TokenService tokenService;

    @GetMapping
    public String index(Model model) {
        return "fence/fence";
    }





    @Scheduled(cron = "0 0 12 ? * WED")
    @ResponseBody
    @PostMapping(value = "/Fen")
    public Result Compare() {

        Calendar  c = new GregorianCalendar();//提供了世界上大多数国家/地区使用的标准日历系统
        int day = c.get(Calendar.DAY_OF_MONTH);    //获取本月当前/已过天数
//        int first = c.getActualMinimum(c.DAY_OF_MONTH);    //获取本月最小天数
        int last = c.getActualMaximum(c.DAY_OF_MONTH);    //获取本月最大天数

        List<String> list=fenceService.selectName();
//        List<FencePo> list3=fenceService.findFence();
        Result result = new Result();
        for (String workPoint:list){
            List<String> list2=fenceService.selectName2(workPoint);

            double b=fenceService.selectMouValue(workPoint);//本月计划产值
            double a=fenceService.selectDayValue(workPoint);//本月实际产值

            double x=(day/last)-(a/b);//阈值
//            String unitWork="临大高速";
            if (x>0 && x<5){
                result.setMsg("当前为"+list2.get(0)+"项目,该"+workPoint+"工点的月产值进度偏差为"+String.format("%.2f", x)+"为四级预警");
            }else if (x>=5 && x<10){
                result.setMsg("当前为"+list2.get(0)+"项目,该"+workPoint+"工点的月产值进度偏差为"+String.format("%.2f", x)+"为三级预警");
            }else if (x>=10 && x<25){
                result.setMsg("当前为"+list2.get(0)+"项目,该"+workPoint+"工点的月产值进度偏差为"+String.format("%.2f", x)+"为二级预警");
            }else if (x>=25){
                result.setMsg("当前为"+list2.get(0)+"项目,该"+workPoint+"工点的月产值进度偏差为"+String.format("%.2f", x)+"为一级预警");
            }else {
                result.setMsg("当前为"+list2.get(0)+"项目,该"+workPoint+"工点的月产值进度偏差为"+String.format("%.2f", x)+",没有达到预警标准");
            }
           /* List<PersonPo> listPo = personService.getPerson();
            MessageListPo po = new MessageListPo();*/

               String content = result.getMsg();
               String WeChatId = "wangyoubin";
            sendService.sendWeChatMsg("text", WeChatId, "@all", "@all", content, "", "",
                    "", "","", "0");
        }
        return result;

    }

}