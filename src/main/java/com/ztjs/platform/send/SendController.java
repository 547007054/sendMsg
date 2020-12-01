package com.ztjs.platform.send;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.mapper.fence.PersonMapper;
import com.ztjs.platform.model.po.fence.PersonPo;
import com.ztjs.platform.service.send.SendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/8/27
 * @Version: v1.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("send/send")
public class SendController  extends ServiceImpl<PersonMapper,PersonPo> {
    private final SendService sendWechatUtils;


    @GetMapping
    public String index() {return "send/send";}

    /**
     * 发送文本信息
     * @return
     */
    @PostMapping(value = "/sendMsg")
    public @ResponseBody
    Result sendMsg(@RequestBody Object obj) {
        Result result = new Result();
        try {
            System.out.println(obj);
            String[] str =  obj.toString().split(",");
            String msgtype = str[0].substring(9);
            String touser = str[1].substring(8);
            String toparty = str[2].substring(9);
            String totag = str[3].substring(7);
            String content ="";String title ="";String description ="";String url ="";String picurl ="";
            System.out.println("str4"+str[4]);
            content = str[4].substring(9,str[4].length()-1);
            System.out.println(content);


            PersonPo po = new PersonPo();
            po.setWeChatId(touser);
            int flag = -1;
            if(getPerson(po)!=null){
                flag = sendWechatUtils.sendWeChatMsg(msgtype, touser, toparty, totag, content, "", title,
                        description, url, picurl, "0");
            }

            if(flag==1){
                result.setCode(200);
                result.setMsg("发送成功！");
            }else if(flag==-1){
                result.setCode(500);
                result.setMsg("请填写正确的接收人！");
            }else {
                result.setCode(500);
                result.setMsg("发送失败！");
            }
        } catch (Exception e) {
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 判断是否存在
     * @param po
     * @return
     */
    public PersonPo getPerson(PersonPo po){
        QueryWrapper<PersonPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("WE_CHAT_ID",po.getWeChatId());
        return this.baseMapper.selectOne(queryWrapper);
    }
}
