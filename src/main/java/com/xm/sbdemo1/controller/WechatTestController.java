package com.xm.sbdemo1.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.config.WeiXinConfig;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.service.UserService;
import com.xm.sbdemo1.util.HttpsUtil;
import com.xm.sbdemo1.util.IdGenerator;
import com.xm.sbdemo1.util.UserInfoUtil;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * 获取微信用户信息并存入数据库
 * 重定向user/login验证是否管理员
 * <p>
 * 获取过程（返回数据均为json）
 * I 访问 https://open.weixin.qq.com/connect/oauth2/authorize?appid=xxs&redirect_uri=xx&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect"
 * 获取code （snsapi_base只获取openid  snsapi_userinfo授权所有）
 * II 访问 https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code
 * 获取access_token（过期时间7200s）和openid（唯一标识）
 * III 访问https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN
 * 获取用户信息
 */
@Controller
@RequestMapping("/weixin")
@CrossOrigin
public class WechatTestController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeiXinConfig weiXinConfig;

    /**
     * @api {GET} /weixin/getAccess_Token 获取微信token
     * @apiVersion 1.0.0
     * @apiGroup WechatTestController
     * @apiName getWechatToken
     * @apiDescription 获取微信token（需要上下文勿操作）
     * @apiParam (请求参数) {String} code
     * @apiParam (请求参数) {String} state
     * @apiParam (请求参数) {Object} attributes
     * @apiParam (请求参数) {Object} session
     * @apiParamExample 请求参数示例
     * code=wK282iqt&session=null&attributes=null&state=hry9Nsc1
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * "KeSEG"
     */
    @RequestMapping("/getAccess_Token")
    public String getWechatToken(@RequestParam(name = "code", required = false) String code,
                                 @RequestParam(name = "state") String state,
                                 RedirectAttributes attributes,
                                 HttpSession session) {

        System.out.println("①收到请求，请求数据为获取code为-----" + code + "-----state：" + state + "\n");

        //通过code换取网页授权web_access_token
        if (code != null || !(code.equals(""))) {

            String APPID = weiXinConfig.getAppid();
            String SECRET = weiXinConfig.getSecret();
            String CODE = code;
            String WebAccessToken = "";
            String openId = "";
            Long userid;


            //替换字符串，获得请求URL
            String token = UserInfoUtil.getWebAccess(APPID, SECRET, CODE);
            System.out.println("②获取access_token地址：" + token + "\n");
            //通过https方式请求获得web_access_token
            String response = HttpsUtil.httpsRequestToString(token, "GET", null);
            JSONObject jsonObject = JSON.parseObject(response);
            System.out.println("③jsonObject------" + jsonObject + "\n");
            if (null != jsonObject) {
                try {

                    WebAccessToken = jsonObject.getString("access_token");
                    openId = jsonObject.getString("openid");
                    System.out.println("④获取access_token成功-----" + WebAccessToken + "-----" + openId + "\n");

                    //-----------------------拉取用户信息...替换字符串，获得请求URL
                    String userMessage = UserInfoUtil.getUserMessage(WebAccessToken, openId);
                    System.out.println("⑤userMessage----" + userMessage + "\n");
                    //通过https方式请求获得用户信息响应
                    String userMessageResponse = HttpsUtil.httpsRequestToString(userMessage, "GET", null);

                    JSONObject userMessageJsonObject = JSON.parseObject(userMessageResponse);

                    System.out.println("⑥userMessagejsonObject-----" + userMessageJsonObject + "\n");

                    if (userMessageJsonObject != null) {
                        try {
                            //用户昵称
                            String nickName = userMessageJsonObject.getString("nickname");
                            //用户性别
                            String sex = userMessageJsonObject.getString("sex");
                            sex = (sex.equals("1")) ? "男" : "女";
                            //用户唯一标识
                            String openid = userMessageJsonObject.getString("openid");

                            String headimgurl = userMessageJsonObject.getString("headimgurl");

                            System.out.println("用户昵称：      " + nickName);
                            System.out.println("用户性别：      " + sex);
                            System.out.println("用户头像url：   " + headimgurl);
                            System.out.println("用户的唯一标识：" + openid);

                            //MD5加密算法 加密openid 视安全情况
//                            openid = new SimpleHash("MD5",openid,null,1024).toString();

                            //获取成果，存入数据库(注册)
                            if (userService.existswxid(openid) == null) {
                                IdGenerator generator = new IdGenerator();
                                userid = generator.useridGenerator();
                                while (userService.queryByUserid(userid) != null) {
                                    userid = generator.useridGenerator();
                                }
                                boolean sucFlag = userService.regist(userid, openid, nickName, sex);
                            }

//                            User user = userService.existswxid(openid);
                            attributes.addFlashAttribute("wxid", openId);
//                            attributes.addFlashAttribute("wxnickname",nickName);
//                            attributes.addFlashAttribute("sex",sex);
//                            session.setAttribute("img",headimgurl);
//
//                            session.setAttribute("User",user);


                        } catch (JSONException e) {
                            throw new BasicException("/weixin/getAccess_Token", "获取opid失败");

//                            System.out.println("获取userName失败");
                        }
                    }

                } catch (JSONException e) {
                    WebAccessToken = null;// 获取code失败
                    throw new BasicException("/weixin/getAccess_Token", "获取WebAccessToken失败");
//                    System.out.println("获取WebAccessToken失败");
                }
            }
        }

//        return new RedirectView("/user/shirologin/");
        return "redirect:/login/usrlogin";
    }
}
