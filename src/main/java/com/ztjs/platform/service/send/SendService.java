package com.ztjs.platform.service.send;

import com.ztjs.platform.mapper.fence.TokenMapper;
import com.ztjs.platform.model.po.fence.TokenPo;
import com.ztjs.platform.service.fence.TokenService;
import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @Author: Lenovo-卫瑞涛
 * @Date: 2019/8/27
 * @Version: v1.0
 */
@AllArgsConstructor
@Service
public class SendService  {
    // 系统properties文件名称
    // private static final String EMAILCONFIG = "emailAndMsgConfig";
    // 发送消息类型
    private final static String MSGTYPE = "text";
    // 发送消息分组所有成员
    private final static String TOPARTY = "@all";
    // 获取配置文件中的值
    @Value("${wechat.corpid}")
    private final static String CORPID = "wwc1e064df0e6702fc";// 需要自己申请，官网有试用企业号
    // 可以申请试用
    @Value("${wechat.corpsecret}")
    private final static String CORPSECRET ="fepFum5Fy0WB_eA4WLvH46WNnMCJXr131wSgjz5HNqc";
    // 获取访问权限码URL
    private final static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    // 创建会话请求URL
    private final static String CREATE_SESSION_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
    //上传图片URL
    public static String PIC_URL="https://qyapi.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
   //上传临时素材URL
    public static String uploadTempMaterial_url="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    //public static String uploadTempMaterial_url="https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token";
    //封面图片id
    public static String MEDIA_ID;
    //图片url
    public static String url;
    @Autowired
    private TokenMapper tokenMapper;

    private final TokenService tokenService;

    // 获取接口访问权限码
    public static String getAccessToken() {

        HttpClient client = new HttpClient();
//        PostMethod post = new PstMethod(ACCESS_TOKEN_URL);
        GetMethod get = new GetMethod(ACCESS_TOKEN_URL);
        get.releaseConnection();
        get.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        NameValuePair[] param = {new NameValuePair("corpid", CORPID), new NameValuePair("corpsecret", CORPSECRET)};
        // 设置策略，防止报cookie错误
        DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
        // 给post设置参数
        get.setQueryString(param);
        String result = null;
        try {
            client.executeMethod(get);
            result = new String(get.getResponseBodyAsString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将数据转换成json

        if (result == null || result == "") {
            System.out.println("*****************");
            System.out.println("result:null");
        } else {
            System.out.println("result is not  null:" + result.toString());
            JSONObject jasonObject = JSONObject.fromObject(result);
            result = (String) jasonObject.get("access_token");
            // System.out.println(result);

            get.releaseConnection();
        }
        //tokenService.addToken(tokenPo);
        System.out.println("值"+result);
        return result;

    }

    /**
     * 企业接口向下属关注用户发送微信消息(实现方式一)
     *
     * @param touser  成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，
     *                则向关注该企业应用的全部成员发送
     * @param toparty 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * @param totag   标签ID列表，多个接收者用‘|’分隔。当touser为@all时忽略本参数
     * @param content 消息内容
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String sendWeChatMessage(String touser, String toparty, String totag, String content) {
        HttpClient client = new HttpClient();
        String ACCESS_TOKEN = getAccessToken();
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + touser + "\",");
        sb.append("\"toparty\":" + "\"" + toparty + "\",");
        sb.append("\"totag\":" + "\"" + totag + "\",");
        sb.append("\"msgtype\":" + "\"" + "text" + "\",");
        sb.append("\"agentid\":" + "\"" + "1000002" + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + content + "\"},");
        sb.append("\"debug\":" + "\"" + "1" + "\"");
        sb.append("}");
        // 请求链接
        String url = CREATE_SESSION_URL + ACCESS_TOKEN;
        PostMethod post = new PostMethod(url);
        post.releaseConnection();
        post.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        // 设置策略，防止报cookie错误
        DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
        // 给post设置参数
        post.setRequestBody(sb.toString());
        String result = "";
        try {
            client.executeMethod(post);
            result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        post.releaseConnection();

        return result;

    }

    /**
     * 此方法可以发送任意类型消息
     *
     * @param msgType     text|image|voice|video|file|news
     * @param touser      成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，
     *                    则向关注该企业应用的全部成员发送
     * @param toparty     部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * @param totag       标签ID列表，多个接收者用‘|’分隔。当touser为@all时忽略本参数
     * @param content     msgType=text时 ,文本消息内容
     * @param mediaId     msgType=image|voice|video时 ,对应消息信息ID（--------）
     * @param title       msgType=news|video时，消息标题
     * @param description msgType=news|video时，消息描述
     * @param url         msgType=news时，消息链接
     * @param picurl      msgType=news时，图片路径
     * @param safe        表示是否是保密消息，0表示否，1表示是，默认0
     */
    public  int sendWeChatMsg(String msgType, String touser, String toparty, String totag, String content, String mediaId, String title,
                                     String description, String url, String picurl, String safe) {

        URL uRl;
        String ACCESS_TOKEN = SendService.getAccessToken();
        // 拼接请求串
        String action = CREATE_SESSION_URL +ACCESS_TOKEN;
        // 封装发送消息请求json
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + touser + "\",");
        sb.append("\"toparty\":" + "\"" + toparty + "\",");
        sb.append("\"totag\":" + "\"" + totag + "\",");
        sb.append("\"toall\":" + "\"" + "0" + "\",");
        sb.append("\"agentid\":" + "\"" + "1000002" + "\",");
        if (msgType.equals("text")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"text\":" + "{");
            sb.append("\"content\":" + "\"" + content + "\"");
            sb.append("}");
        } else if (msgType.equals("image")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"image\":" + "{");
            sb.append("\"media_id\":" + "\"" + mediaId + "\"");
            sb.append("}");
        } else if (msgType.equals("voice")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"voice\":" + "{");
            sb.append("\"media_id\":" + "\"" + mediaId + "\"");
            sb.append("}");
        } else if (msgType.equals("video")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"video\":" + "{");
            sb.append("\"media_id\":" + "\"" + mediaId + "\",");
            sb.append("\"title\":" + "\"" + title + "\",");
            sb.append("\"description\":" + "\"" + description + "\"");
            sb.append("}");
        } else if (msgType.equals("file")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"file\":" + "{");
            sb.append("\"media_id\":" + "\"" + mediaId + "\"");
            sb.append("}");
        } else if (msgType.equals("news")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"news\":" + "{");
            sb.append("\"articles\":" + "[");
            sb.append("{");
            sb.append("\"title\":" + "\"" + title + "\",");
            sb.append("\"description\":" + "\"" + description + "\",");
            sb.append("\"url\":" + "\"" + url + "\",");
            sb.append("\"picurl\":" + "\"" + picurl + "\"");
            sb.append("\"btntxt\":" + "\"" + "更多" + "\"");
            sb.append("}");
            sb.append("]");
            sb.append("}");
        }else if (msgType.equals("mpnews")) {
            sb.append("\"msgtype\":" + "\"" + msgType + "\",");
            sb.append("\"mpnews\":" + "{");
            sb.append("\"articles\":" + "[");
            sb.append("{");
            sb.append("\"title\":" + "\"" + title + "\",");
            sb.append("\"thumb_media_id\":" + "\"" + MEDIA_ID + "\",");
            sb.append("\"author\":" + "\"" + description + "\",");
            sb.append("\"content\":" + "\"" + content + "\",");
            sb.append("\"content_source_url\":" + "\"" + url + "\"");
            sb.append("}");
            sb.append("]");
            sb.append("}");
            sb.append("\"enable_id_trans\":" + "\"" + "0" + "\"");
        }
        sb.append(",\"safe\":" + "\"" + safe + "\",");
        sb.append("\"debug\":" + "\"" + "1" + "\"");
        sb.append("}");
        String json = sb.toString();
        try {

            uRl = new URL(action);

            HttpsURLConnection http = (HttpsURLConnection) uRl.openConnection();

            http.setRequestMethod("POST");

            http.setRequestProperty("Content-Type","application/json;charset=UTF-8");

            http.setDoOutput(true);

            http.setDoInput(true);

            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//
            // 连接超时30秒

            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //
            // 读取超时30秒

            http.connect();

            OutputStream os = http.getOutputStream();

            os.write(json.getBytes("UTF-8"));// 传入参数

            InputStream is = http.getInputStream();

            int size = is.available();

            byte[] jsonBytes = new byte[size];

            is.read(jsonBytes);

            String result = new String(jsonBytes, "UTF-8");

            System.out.println("请求返回结果:" + result);

            os.flush();

            os.close();

            int flag = Integer.parseInt(result.substring(result.indexOf(":")+1,result.indexOf(",")));

            if(flag==0){
                return 1;
            }else {
                return 0;
            }

        } catch (Exception e) {

            e.printStackTrace();

            return 0;
        }
    }

    /**
     * 企业接口向下属关注用户发送微信消息(实现方式二)
     *
     * @param touser  成员ID列表（消息接收者，多个接收者用‘|’分隔，最多支持1000个）。特殊情况：指定为@all，
     *                则向关注该企业应用的全部成员发送
     * @param toparty 部门ID列表，多个接收者用‘|’分隔，最多支持100个。当touser为@all时忽略本参数
     * @param totag   标签ID列表，多个接收者用‘|’分隔。当touser为@all时忽略本参数
     * @param content 消息内容
     * @param safe    消息是否保密
     * @return
     */
    public static void sendWeChatMsgText(String touser, String toparty, String totag, String content, String safe) {

        URL uRl;
        String ACCESS_TOKEN = getAccessToken();
        System.out.println(ACCESS_TOKEN);
        // 拼接请求串
        String action = CREATE_SESSION_URL + ACCESS_TOKEN;
        // 封装发送消息请求json
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append("\"touser\":" + "\"" + touser + "\",");
        sb.append("\"toparty\":" + "\"" + toparty + "\",");
        sb.append("\"totag\":" + "\"" + totag + "\",");

        sb.append("\"msgtype\":" + "\"" + MSGTYPE + "\",");
        sb.append("\"text\":" + "{");
        sb.append("\"content\":" + "\"" + content + "\"");
        sb.append("}");

        sb.append(",\"safe\":" + "\"" + safe + "\",");
        sb.append("\"agentid\":" + "\"" + "1000002" + "\",");
        sb.append("\"debug\":" + "\"" + "1" + "\"");
        sb.append("}");
        String json = sb.toString();
        System.out.println("==========================");
        System.out.println(json);
        System.out.println("==========================");
        try {
            uRl = new URL(action);
            HttpsURLConnection http = (HttpsURLConnection) uRl.openConnection();
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type",
                    "application/json;charset=UTF-8");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//
            // 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //
            // 读取超时30秒
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(json.getBytes("UTF-8"));// 传入参数
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String result = new String(jsonBytes, "UTF-8");
            System.out.println("请求返回结果：" + result);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @desc ：微信上传素材的请求方法
     *
     * @param requestUrl  微信上传临时素材的接口url
     * @param file    要上传的文件
     * @return String  上传成功后，微信服务器返回的消息
     */
    public static String httpRequest(String requestUrl, File file) {
        StringBuffer buffer = new StringBuffer();

        try{
            //1.建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  //打开链接

            //1.1输入输出设置
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setUseCaches(false); // post方式不能使用缓存
            //1.2设置请求头信息
            httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);

            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);

            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            //5.将微信服务器返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();


        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return buffer.toString();
    }
    /**
     * @desc ：获取图片的url
     */
    public String getPicUrl(String fileUrl){
        String accessToken= getAccessToken();
        //1.创建本地文件
        File file=new File(fileUrl);
        //2.拼接请求url
        PIC_URL=PIC_URL.replace("ACCESS_TOKEN", accessToken);
        //3.调用接口，发送请求，上传文件到微信服务器
        String result= SendService.httpRequest(PIC_URL, file);

        //4.json字符串转对象：解析返回值，json反序列化
        result = result.replaceAll("[\\\\]", "");
        System.out.println("result:" + result);
        JSONObject resultJSON = JSONObject.fromObject(result);
        url = resultJSON.get("url").toString();
        //5.返回参数判断
        if (resultJSON != null) {
            if (resultJSON.get("url") != null) {
                System.out.println("上传图片成功");
                return url;
            } else {
                System.out.println("上传图片失败");
                return null;
            }
        }
        return null;
    }


   /*  * @desc ：上传临时素材
     *
     * @param accessToken   接口访问凭证
     * @param type   媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
     * @param fileUrl  本地文件的url。例如 "D/1.img"。
     * @return JSONObject   上传成功后，微信服务器返回的参数，有type、media_id    、created_at
*/
   @Transactional(rollbackFor=Exception.class)
    public JSONObject uploadTempMaterial(String type, String fileUrl){
       String accessToken= getAccessToken();

        TokenPo tokenPo =new TokenPo();
        tokenPo =tokenService.selectToken();
        String newToken = tokenPo.getToken().concat("&type=image");
//       System.out.println("saddddddddddddddddddddd是"+tokenPo.getToken());
       System.out.println("saddddddddddddddddddddd是"+newToken);
        //1.创建本地文件
        File file=new File(fileUrl);
        System.out.println("地址是"+uploadTempMaterial_url);
        //2.拼接请求url
     /*      uploadTempMaterial_url = uploadTempMaterial_url.replace("ACCESS_TOKEN", newToken)
                   .replace("TYPE", type);*/

       uploadTempMaterial_url="https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=".concat(newToken);

           System.out.println("url地址" + uploadTempMaterial_url);



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


    public void main(String[] args) {


    }
}
