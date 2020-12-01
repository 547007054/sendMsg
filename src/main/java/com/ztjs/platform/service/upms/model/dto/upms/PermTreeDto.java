package com.ztjs.platform.service.upms.model.dto.upms;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司
 * @Author: 梁声洪
 * @Date: 2019 13:53
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
@Data
public class PermTreeDto implements Serializable {

    private static final long serialVersionUID = -6318233935441248682L;

    private Integer id;

    private Integer parentId;

    private String permName;

    private String permCode;

    private Boolean checked = false;

    private Boolean open = true;

}