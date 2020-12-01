package com.ztjs.platform.common.exception;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:27
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public class ValidateCodeException extends Exception {

    private static final long serialVersionUID = -5081562339725475188L;

    public ValidateCodeException() {

    }

    public ValidateCodeException(String msg) {
        super(msg);
    }

}