package com.ztjs.platform.send;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ztjs.platform.common.entity.Result;
import com.ztjs.platform.mapper.fence.PersonMapper;
import com.ztjs.platform.mapper.fence.TokenMapper;
import com.ztjs.platform.model.po.fence.PersonPo;
import com.ztjs.platform.model.po.fence.TokenPo;
import com.ztjs.platform.service.fence.TokenService;
import com.ztjs.platform.service.send.SendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/9/12
 * @Version: v1.0
 */
@Slf4j
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("send/news")
public class NewsController  extends ServiceImpl<PersonMapper,PersonPo> {
    private final SendService sendService;
    private final TokenService tokenService;
    private final TokenMapper tokenMapper;
    public static String MEDIA_ID;
    public static String uploadTempMaterial_url="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    @GetMapping
    public String index() {return "send/news";}

    /**
     * 发送图文信息
     * @return
     */
    @PostMapping(value = "/sendMsg")
    public @ResponseBody
    Result sendMsg(@RequestBody Object obj) {
        Result result = new Result();
        try {
            System.out.println(obj);
            String[] str =  obj.toString().split(",");
            System.out.println("0"+str[0]);
            System.out.println("1"+str[1]);
            System.out.println("2"+str[2]);
            System.out.println("3"+str[3]);
            System.out.println("4"+str[4]);
            //System.out.println("5"+str[5]);
            //System.out.println("6"+str[6]);
            String touser = str[0].substring(8);
            String toparty = str[1].substring(9);
            String totag = str[2].substring(7);
            String title = str[3].substring(7);
            String content = "<p".concat(str[4].substring(9).substring(str[4].substring(9).indexOf(">")));
            String src [] = content.split("}");
            System.out.println("content"+content);
            //String author = str[5].substring(8);
            //String url =str[6].substring(5,str[6].length()-1);
            content = src[0].replaceAll("\"","\'");
            System.out.println("content1是"+content);
            PersonPo po = new PersonPo();
            po.setWeChatId(touser);
            int flag = -1;
            if(getPerson(po)!=null){
                flag = sendService.sendWeChatMsg("mpnews", touser, toparty, totag, content, "", title,
                    "", "", "", "0");
            }
            if(flag==-1){
                result.setCode(500);
                result.setMsg("请填写正确的接收人！");
            }else if(flag==0){
                result.setCode(500);
                result.setMsg("发送失败！");
            }else {
                result.setCode(200);
                result.setMsg("发送成功！");
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

    /**
     * 上传封面图片
     * @return
     */
    @RequestMapping(value = "/upload")
    public @ResponseBody
    Result upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        Result result = new Result();
        String type="image";
        String fileUrl = request.getParameter("fileUrl");
        File file = new File(fileUrl);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            if (!StrUtil.isEmptyIfStr(multipartFile)&& multipartFile.getSize() < 2000000  && multipartFile.getSize() > 0 ) {
                System.out.println(multipartFile.getSize());
                String fileName = multipartFile.getOriginalFilename();
                File targetFile = new File(fileUrl + fileName);
                multipartFile.transferTo(targetFile);
                fileUrl = fileUrl + fileName;
                System.out.println("地址"+fileUrl);
                SendService tms=new SendService(tokenMapper,tokenService);
                tms.uploadTempMaterial(type, fileUrl);
               //TempMaterial(type, fileUrl);
                File file1 = new File(fileUrl);
                if (file1.exists()) {
                    file1.delete();
                }
                result.setData("成功！");
                result.setCode(200);
                result.setMsg("添加成功！");
            }else {
                result.setData("失败！");
                result.setMsg("图片过大！");
                result.setCode(500);
            }
        } catch (Exception e) {
            result.setData("失败！");
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 上传插入图片
     * @return
     */
    @RequestMapping(value = "/uploadIPC")
    public @ResponseBody
    Result uploadIPC(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
        Result result = new Result();
        String fileUrl = request.getParameter("fileUrl");
        File file = new File(fileUrl);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            if (!StrUtil.isEmptyIfStr(multipartFile)&& multipartFile.getSize() < 2000000  && multipartFile.getSize() > 0 ) {
                String fileName = multipartFile.getOriginalFilename();
                File targetFile = new File(fileUrl + fileName);
                multipartFile.transferTo(targetFile);
                fileUrl = fileUrl + fileName;
                System.out.println(fileUrl);
                //上传临时素材
                SendService tms=new SendService(tokenMapper,tokenService);
                String data = tms.getPicUrl(fileUrl);
                File file1 = new File(fileUrl);
                if (file1.exists()) {
                    file1.delete();
                }
                if(data!=null){
                    result.setData(data);
                    result.setCode(200);
                }else {
                    result.setData("0");
                    result.setCode(500);
                }
                result.setMsg("添加成功！");
            }else {
                result.setData("失败！");
                result.setMsg("图片过大！");
                result.setCode(500);
            }
        } catch (Exception e) {
            result.setData("0");
            result.setCode(500);
            result.setMsg("系统繁忙，请稍后再试！");
            e.printStackTrace();
        }
        return result;
    }
    public JSONObject TempMaterial(String type, String fileUrl){
          TokenPo tokenPo=new TokenPo();
          tokenPo=tokenService.selectToken();

        //1.创建本地文件
        File file=new File(fileUrl);
        //2.拼接请求url
        uploadTempMaterial_url=uploadTempMaterial_url.replace("ACCESS_TOKEN", tokenPo.getToken())
                .replace("TYPE", type);
        System.out.println("url地址"+uploadTempMaterial_url);


        //3.调用接口，发送请求，上传文件到微信服务器
        String result= SendService.httpRequest(uploadTempMaterial_url, file);
        //4.json字符串转对象：解析返回值，json反序列化
        result = result.replaceAll("[\\\\]", "");
        System.out.println("result:" + result);
        JSONObject resultJSON = JSONObject.fromObject(result);
        MEDIA_ID = resultJSON.get("media_id").toString();
        //5.返回参数判断
        if (resultJSON != null) {
            if (resultJSON.get("media_id") != null) {
                System.out.println("上传" + type + "永久素材成功");
                return resultJSON;
            } else {
                System.out.println("上传" + type + "永久素材失败");
            }
        }

        return null;
    }
}
