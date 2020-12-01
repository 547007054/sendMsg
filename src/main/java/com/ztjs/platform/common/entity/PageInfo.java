package com.ztjs.platform.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:18
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 3484783132365213461L;

    private Integer pageNo;
    private Integer pageSize;
    private long total;
    private List<T> rows;

}