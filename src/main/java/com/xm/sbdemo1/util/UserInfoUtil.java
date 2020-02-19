package com.xm.sbdemo1.util;

import com.xm.sbdemo1.config.WeiXinConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 获取微信用户信息的工具类
 */

public class UserInfoUtil {

    //String.format 类似于输出格式 参数插入指定的语言环境
    //获取code的请求地址
    public static String Get_Code = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=STAT#wechat_redirect";

    //替换字符串
    public static String getCode(String APPID, String REDIRECT_URI, String SCOPE) {
        return String.format(Get_Code, APPID, REDIRECT_URI, SCOPE);
    }

    //获取Web_access_token https的请求地址
    public static String Web_access_tokenhttps = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    //替换字符串
    public static String getWebAccess(String APPID, String SECRET, String CODE) {
        return String.format(Web_access_tokenhttps, APPID, SECRET, CODE);
    }

    //拉取用户信息的请求地址
    public static String User_Message = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    //替换字符串
    public static String getUserMessage(String access_token, String openid) {
        return String.format(User_Message, access_token, openid);
    }


    @Autowired
    static WeiXinConfig weiXinConfig;

    public static void main(String[] args) {

        String REDIRECT_URI = "http://www.ueof.top/weixin/getAccess_Token";
        String SCOPE = "snsapi_userinfo";
        //appId 此处appId为测试号 需修改
        String appId = weiXinConfig.getAppid();

        String getCodeUrl = getCode(appId, REDIRECT_URI, SCOPE);
        System.out.println("getCodeUrl:" + getCodeUrl);
    }
}
