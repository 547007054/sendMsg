package com.ztjs.platform.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 工具类
 *
 * @Module: 中国铁建华东分公司智慧工地平台
 * @Author: 梁声洪
 * @Date: 2019/8/7 13:48
 * @Copyright: 北京浩坤科技有限公司
 * @Version: v1.0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static Pattern linePattern = Pattern.compile("_(\\w)");
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String lineToHump(String str) {
        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
     *
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * 驼峰转下划线,效率比上面高
     *
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (isBlank(s)) {
            return s;
        }
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (isBlank(s)) {
            return s;
        }
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuffer()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    /**
     * object转String
     *
     * @param object
     * @return
     */
    public static String getString(Object object) {
        return getString(object, "");
    }

    public static String getString(Object object, String defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return object.toString();
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Integer
     *
     * @param object
     * @return
     */
    public static int getInt(Object object) {
        return getInt(object, -1);
    }

    public static int getInt(Object object, Integer defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * object转Boolean
     *
     * @param object
     * @return
     */
    public static boolean getBoolean(Object object) {
        return getBoolean(object, false);
    }

    public static boolean getBoolean(Object object, Boolean defaultValue) {
        if (null == object) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(object.toString());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 使用UTF-8转换String为byte[]
     *
     * @param str
     * @return 默认null
     */
    public static final byte[] getBytes(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述：将iso-8859-1字符串转换为UTF-8，用于解决网络输入乱码
     *
     * @param str
     * @return
     */
    public static final String iso2Utf(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        try {

            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 功能描述：将字符串转换为iso-8859-1，用于解决网络输出乱码
     *
     * @param str
     * @return
     */
    public static final String utf2iso(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        try {

            return new String(str.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 转换字符串的编码格式,将str字符的编码格式转换成utf-8的格式
     *
     * @param str
     * @return
     */
    public static String parseToUTF8(String str) {
        try {
            return java.net.URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将一个String类型的List，拼接为一个String
     *
     * @param lsit
     * @return
     */
    public static String listToString(List<String> lsit) {
        StringBuilder sd = new StringBuilder();
        for (String s : lsit) {
            sd.append(s);
        }
        return sd.toString();
    }

    /**
     * 将String转换为InputStream，使用UTF-8
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static InputStream string2InputStream(String str) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(str.getBytes("UTF-8"));
    }

    /**
     * 将字符串转换为UTF-8的输入流
     *
     * @param str
     * @return
     */
    public static final InputStream str2Ins(String str) {
        byte[] bytes = getBytes(str);
        if (bytes != null) {
            return new ByteArrayInputStream(bytes);
        }
        return null;
    }

    /**
     * InputStream转换为String
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static final String ins2Str(InputStream is) throws IOException {
        if (is == null) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "/r/n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw e;
        } finally {
            is.close();
        }
    }

    /**
     * 字符串转换unicode
     *
     * @param string
     * @return
     */
    public static String string2Unicode(String string) {
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);
            // 转换为unicode：将字符转换为16进制，再前缀"\\u"
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode 转字符串：(结果不稳定)
     * false同时获取正常字符串；true只转换并获取unicode部分，正常字符串将被忽略
     * 1、如果是在代码中直接手动赋值unicode到字符串，则会自动转换为本地中文。
     * 2、如果是通过读取文件等方式获取的unicode，则需要转换为字符串。
     *
     * @param unicode
     * @param only
     * @return
     */
    public static String unicode2String(String unicode, boolean only) {
        StringBuffer string = new StringBuffer();
        if (only) {
            String[] hex = unicode.split("\\\\u");
            for (int i = 1; i < hex.length; i++) {
                // 转换出每一个代码点(16进制转换为10进制数字)
                int data = Integer.parseInt(hex[i], 16);
                // 数字转换为字符，追加到string
                string.append((char) data);
            }
            return string.toString();
        }
        char c;
        char d;
        for (int i = 0; i < unicode.length(); i++) {
            c = unicode.charAt(i);
            //不为\则直接添加
            if ('\\' != c) {
                string.append(c);
                //为\的时侯
            } else {
                d = unicode.charAt(i + 1);
                switch (d) {
                    case 't':
                        d = '\t';
                        break;
                    case 'r':
                        d = '\r';
                        break;
                    case 'n':
                        d = '\n';
                        break;
                    case 'f':
                        d = '\f';
                        break;
                    case 'u':
                        int data = Integer.parseInt(unicode.substring(i + 2, i + 6), 16);
                        string.append((char) data);
                        i += 5;
                        break;
                    default:
                        break;
                }
            }
        }
        return string.toString();
    }

    /**
     * 去除Html标签
     *
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regEx_html = "<[^>]+>";

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");

        return htmlStr.trim();
    }

    /**
     * 大写人民币
     *
     * @param orig
     * @return
     */
    public static String intToRMB(int orig) {
        String singleBit = "零壹贰叁肆伍陆柒捌玖整分角元拾佰仟万拾佰仟亿拾佰仟万";
        String origStr = orig + "";
        int L = origStr.length();
        boolean Z = false, zL;
        zL = Long.valueOf(origStr.substring(0, L)) == 0;
        if (zL) {
            return "零";
        }
        char s0, s1;
        StringBuffer sL = new StringBuffer();
        int n;
        for (int i = 0; i < L; i++) {
            s0 = 0;
            s1 = 0;
            n = origStr.charAt(L - i - 1) - '0';
            if (!(n == 0 && (Z || i == 8 || i == 4 || i == 0) || zL)) {
                s0 = singleBit.charAt(n);
            }
            if (!(n == 0 && (i != 8 && i != 4 && i != 0 || Z && i == 1) || zL)) {
                s1 = singleBit.charAt(i + 13);
            }
            if (s1 > 0) {
                sL.insert(0, s1);
            }
            if (s0 > 0) {
                sL.insert(0, s0);
            }
            Z = n == 0;
        }
        int pos = sL.indexOf("亿万");
        if (pos > 0) {
            sL.deleteCharAt(pos + 1);
        }
        return sL.toString().substring(0, sL.length() - 1);
    }

    /**
     * 根据内容类型判断文件扩展名
     *
     * @param contentType 内容类型
     * @return
     */
    public static String getFileExt(String contentType) {
        String fileExt = "";
        if ("image/jpeg".equals(contentType)) {
            fileExt = ".jpg";

        } else if ("audio/mpeg".equals(contentType)) {
            fileExt = ".mp3";

        } else if ("audio/amr".equals(contentType)) {
            fileExt = ".amr";

        } else if ("video/mp4".equals(contentType)) {
            fileExt = ".mp4";

        } else if ("video/mpeg4".equals(contentType)) {
            fileExt = ".mp4";
        }

        return fileExt;
    }

    /**
     * 把数组转换成set
     *
     * @param array
     * @return
     */
    public static Set<?> array2Set(Object[] array) {
        Set<Object> set = new TreeSet<>();
        for (Object id : array) {
            if (null != id) {
                set.add(id);
            }
        }
        return set;
    }

}