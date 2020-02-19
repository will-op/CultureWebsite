package com.xm.sbdemo1.controller;


import com.xm.sbdemo1.config.MyToken;
import com.xm.sbdemo1.config.WeiXinConfig;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.ResultEnum;
import com.xm.sbdemo1.pojo.Admin;
import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.service.AdminService;
import com.xm.sbdemo1.service.UserService;
import com.xm.sbdemo1.util.IdGenerator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制与其他控制分开 防止shiro误拦截 毕竟shiro的拦截有点六亲不认
 */
@Controller
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private WeiXinConfig weiXinConfig;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    /**
     * @api {GET} /login/usrlogin 用户登录（测试用，获取session）
     * @apiVersion 0.0.1
     * @apiGroup LoginController
     * @apiName usrlogin
     * @apiDescription 用户登录（测试用，获取session）
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * 用户接口sessionid='39dd68e6-ebb4-4507-8dab-215bdefd2682',测试用户信息='User{userid=1666666, wxid='oJp8353u2kg8rhPWb32b800LQG4Y', wxnickname='去创', sex='男', userscore=72}'
     */
    @RequestMapping("/usrlogin")
    @ResponseBody //仅测试时添加
    public String usrlogin(@ModelAttribute("wxid") String wxid) throws AuthenticationException {
        //shiro认证操作
        //获取subject

//        JdbcRealm jdbcRealm = new JdbcRealm();
//        String sql = "select wxid from user where wxid=?";
//        jdbcRealm.setAuthenticationQuery(sql);

        wxid = "oJp8353u2kg8rhPWb32b800LQG4Y";//仅测试
//        String password = "oJp8353u2kg8rhPWb32b800LQG4Y";

//        HashMap<String,Object> map = new HashMap<>();
        MyToken token = new MyToken(wxid);

//        SavedRequest savedRequest = (SavedRequest) session.getAttribute("request");
//        System.out.println(savedRequest);
//        System.out.println(token.getCredentials());
        //执行登录
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
//            map.put("success","loginsuccess");
//            return "redirect:/category/main";
        } catch (AuthenticationException a) {
//            a.printStackTrace();
//            map.put("error","loginfailure");
//            return "";
            throw new BasicException("/login/usrlogin", "认证失败");
        } catch (NullPointerException ne) {
            throw new BasicException(500, "error", "/login/usrlogin", "空指针");
        }
        System.out.println("**************************>> TOKEN >>" + token + ">>**************************");
        System.out.println("**************************>> USER AUTHENTICATION IS SUCCESSFUL >>**************************");
        User user = userService.existswxid(wxid);
        Session session = subject.getSession(true);
        session.setAttribute("User", user);
//        return "redirect:http://www.ueof.top";
        return "用户接口sessionid='" + session.getId() + '\'' + "," +
                "测试用户信息='" + user + '\'';//仅测试
    }


    /**
     * @api {GET} /login/adminlogin 管理员登录（测试用，获取session）
     * @apiVersion 0.0.1
     * @apiGroup LoginController
     * @apiName adminlogin
     * @apiDescription 管理员登录（测试用，获取session）
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * 管理员接口sessionid='39dd68e6-ebb4-4507-8dab-215bdefd2682',测试管理员信息='Admin{adminid='10001', pwd='123456'}'
     */
//    @RequiresRoles(value={"admin","user"},logical = Logical.OR)
    @RequestMapping(value = "/adminlogin")
    @ResponseBody //仅测试
    public String adminlogin(Admin admin) {

        //以下过程有助于理解加密
        String adminid = "10001";//仅测试时添加
        String pwd = "123456";
//        String salt = "abcdefg";
//        Admin admin = new Admin();
//        admin.setSalt(salt);
        admin.setAdminid(adminid);
        admin.setPwd(pwd);
//        String newpwd = new SimpleHash("md5",admin.getPwd(), ByteSource.Util.bytes(admin.getSalt()),1).toHex();
//        System.out.println(newpwd);


        UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminid(), admin.getPwd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            throw new BasicException("login/adminlogin", "认证失败");
        } catch (Exception e) {
            throw new BasicException(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg(), "login/adminlogin", "认证失败");
        }
//        return "redirect:http://127.0.0.1:80"+savedRequest.getRequestUrl();
        System.out.println("**************************>> TOKEN >>" + token + ">>**************************");
        System.out.println("**************************>> ADMIN AUTHENTICATION IS SUCCESSFUL >>**************************");
        Session session = subject.getSession(true);
        session.setAttribute("Admin", admin);
//        return "redirect:/category/main";

        return "管理员接口sessionid='" + session.getId() + '\'' + "," +
                "测试管理员信息='" + admin + '\'';//仅测试
    }

    /**
     * @api {GET} /login/adminregister 管理员注册
     * @apiVersion 0.0.1
     * @apiGroup LoginController
     * @apiName adminregister
     * @apiDescription 管理员注册
     * @apiParam (请求参数) {String} adminid
     * @apiParam (请求参数) {String} pwd
     * @apiParamExample 请求参数示例
     * adminid=10002&pwd=123456
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * "dqabUCM"
     */
    @RequestMapping("/adminregister")
    public String adminregister(Admin admin) throws Exception {

        SecureRandomNumberGenerator random = new SecureRandomNumberGenerator();
        IdGenerator generator = new IdGenerator();
        String adminid = generator.adminidGenerator();
        while (adminService.queryAllFromAdmin(adminid) != null) {
            adminid = generator.adminidGenerator();
        }
        String salt = random.nextBytes(3).toHex();
        admin.setSalt(salt);
        admin.setAdminid(generator.adminidGenerator());

        String pwd = new SimpleHash("md5", admin.getPwd(), ByteSource.Util.bytes(admin.getSalt()), 1).toHex();
        boolean regFlag = adminService.adminRegister(admin.getAdminid(), pwd, salt);
        if (!regFlag) {
            throw new BasicException("/login/adminregister", "注册失败");
        }

        return "redirect:/admin/tologin";
    }

}
