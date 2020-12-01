package com.ztjs.platform;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 中国铁建华东分公司智慧工地平台 启动程序入口
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 12:38
 * @Copyright: 北京浩坤科技有限公司
 *
 * @Version: v1.0
 */
@Slf4j
@EnableScheduling
@SpringBootApplication
public class BeginApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(BeginApplication.class, args);


    }

}