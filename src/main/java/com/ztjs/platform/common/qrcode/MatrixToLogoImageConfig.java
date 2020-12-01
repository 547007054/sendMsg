package com.ztjs.platform.common.qrcode;

import java.awt.Color;

/**
 * TODO
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:36
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public class MatrixToLogoImageConfig {

    /** logo默认边框颜色 */
    public static final Color DEFAULT_BORDER_COLOR = Color.RED;

    /** logo默认边框宽度 */
    public static final int DEFAULT_BORDER = 2;

    /** logo大小默认为照片的1/5 */
    public static final int DEFAULT_LOGO_PART = 5;

    private final int border = DEFAULT_BORDER;
    private final Color borderColor;
    private final int logoPart;

    public MatrixToLogoImageConfig() {
        this(DEFAULT_BORDER_COLOR, DEFAULT_LOGO_PART);
    }

    public MatrixToLogoImageConfig(Color borderColor, int logoPart) {
        this.borderColor = borderColor;
        this.logoPart = logoPart;
    }

    public Color getBorderColor() {
        return this.borderColor;
    }

    public int getBorder() {
        return this.border;
    }

    public int getLogoPart() {
        return this.logoPart;
    }

}