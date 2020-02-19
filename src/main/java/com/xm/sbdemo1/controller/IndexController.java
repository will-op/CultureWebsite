package com.xm.sbdemo1.controller;

import com.xm.sbdemo1.config.WeiXinConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/index")
@CrossOrigin
public class IndexController {


    @Autowired
    private WeiXinConfig weiXinConfig;

//    @RequestMapping("/kuimeng")
//    public String toWechatAuthorize(HttpServletRequest request){
//
////        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
////        session.setAttribute("request",savedRequest);
//        System.out.println("**************************>>DO WECHAT AUTHORIZE >>**************************");
//        String wechatGetToken = weiXinConfig.getGetTokenUrl();
//        return "redirect:"+wechatGetToken;
//    }

    //该接口仅在测试时调用 模拟微信登录
    @RequestMapping("/kuimeng")
    public String toWechatAuthorize(RedirectAttributes attributes) {

//        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//        session.setAttribute("request",savedRequest);
        System.out.println("**************************>>DO WECHAT AUTHORIZE >>**************************");
//        String wxid = "oJp8353u2kg8rhPWb32b800LQG4Y";
//        attributes.addFlashAttribute("wxid",wxid);
        return "redirect:/login/usrlogin";
    }
}
