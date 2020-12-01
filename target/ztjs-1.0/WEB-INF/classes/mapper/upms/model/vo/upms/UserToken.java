package com.ztjs.platform.model.vo.upms;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录用户 Token
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 18:30
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class UserToken implements Serializable {

    private static final long serialVersionUID = -5153396170715148966L;

    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密字符
     */
    private String salt;

    /**
     * 生成token
     */
    private String token;

}