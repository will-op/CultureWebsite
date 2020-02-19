package com.xm.sbdemo1.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重写shiro表单控制器 通过判断pattern来重定向登录地址
 */
public class UsrFormAuthenticationFilter extends FormAuthenticationFilter {


    private static final String ADMIN_PATTERN = "/admin/";
//    private static final String USR_LOGINURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0696c90951e2f466&redirect_uri=http://n24m627671.qicp.vip/weixin/getAccess_Token&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";

    private static final String USR_LOGINURL = "/index/kuimeng";

    private static final String ADMIN_TEST_LOGINURL = "/login/adminlogin";

    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        super.saveRequest(request);
        String loginUrl;
        if (httpServletRequest.getRequestURI().contains(ADMIN_PATTERN)) {
            System.out.println("**************************>> FOR ADMINISTRATOR LOGIN ON PC >>**************************");
            loginUrl = getLoginUrl();
//              loginUrl = ADMIN_TEST_LOGINURL;
        } else {
            System.out.println("**************************>> FOR CONSUMER LOGIN ON MOBILE>>**************************");
            loginUrl = USR_LOGINURL;
        }
        WebUtils.issueRedirect(httpServletRequest, httpServletResponse, loginUrl);
    }

//    @Override
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
//
//
//    }

//    @Override
//    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
//        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//        String superURL ;
//        System.out.println("issueSuccessRedirect");
//        if(savedRequest!=null){
//            superURL = savedRequest.getRequestUrl();
//            System.out.println(superURL);
//            if(superURL== null || "".equals(superURL)){
//                superURL = getSuccessUrl();
//            }
//        }else {
//            superURL = getSuccessUrl();
//            System.out.println(superURL);
//        }
//        WebUtils.redirectToSavedRequest(request,response,superURL);
//    }

}


