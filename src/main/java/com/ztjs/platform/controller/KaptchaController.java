package com.ztjs.platform.controller;

import com.google.code.kaptcha.Producer;
import com.ztjs.platform.common.constant.CommonConstants;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * 验证码生成 控制器
 *
 * @Module: 中国铁建华东分公司
 * @Author: 梁声洪
 * @Date: 2019 11:44
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Controller
@Scope("prototype")
@AllArgsConstructor
@RequestMapping("/kaptcha")
public class KaptchaController {

    private final Producer producer;

    private final RedisTemplate redisTemplate;

    /**
     * 生成验证码
     *
     * @param response
     */
    @GetMapping
    public void kaptcha(HttpServletRequest request, HttpServletResponse response) {
        try{
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String capText = producer.createText();

            //保存验证码信息
            String randomStr = request.getParameter("randomStr");
            redisTemplate.opsForValue().set(CommonConstants.DEFAULT_CODE_KEY + randomStr, capText, 60, TimeUnit.SECONDS);
            BufferedImage bi = producer.createImage(capText);
            ServletOutputStream out = null;
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}