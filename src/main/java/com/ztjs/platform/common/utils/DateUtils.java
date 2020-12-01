package com.ztjs.platform.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共日期工具类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:55
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public class DateUtils {

    public static String[] parsePatterns = {
            "yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd HH:mm",
            "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss",
            "yyyy/MM/dd HH:mm",
            "yyyy-MM"
    };

    /**
     * 获取系统时间Timestamp
     *
     * @return
     */
    public static Timestamp getSysTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 格式化时间
     *
     * @param timestamp
     * @return
     */
    public static String dateFormat(Date timestamp) {
        SimpleDateFormat format = new SimpleDateFormat(parsePatterns[1]);
        return format.format(timestamp);
    }

    /**
     * 字符串转换成日期 如果转换格式为空，则利用默认格式进行转换操作
     *
     * @param str    字符串
     * @param format 日期格式
     * @return
     */
    public static Date str2Date(String str, String format) {
        if (null == str || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转换时间戳
     *
     * @param timestamp
     * @return
     */
    public static Timestamp dateFormat(String timestamp) {
        Date date = str2Date(timestamp, parsePatterns[1]);
        return new Timestamp(date.getTime());
    }

    /**
     * 字符串转换时间戳
     *
     * @param timestamp
     * @param format
     * @return
     */
    public static Timestamp dateFormat(String timestamp, String format) {
        Date date = str2Date(timestamp, format);
        return new Timestamp(date.getTime());
    }

}