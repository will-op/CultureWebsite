package com.xm.sbdemo1.realm;

import com.xm.sbdemo1.config.MyToken;
import com.xm.sbdemo1.pojo.Admin;
import com.xm.sbdemo1.service.AdminService;
import com.xm.sbdemo1.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    //认证逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

//        String roles = "admin";
//        String username = "oJp8353u2kg8rhPWb32b800LQG4Y";
        String adminid = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (adminService.queryAllFromAdmin(adminid) != null) {
            Set<String> roles = getroles();
            info.setRoles(roles);
        } else if (userService.existswxid(adminid) != null) {
            System.out.println("**************************>> DOGETAUTHORIZATIONINFO >>**************************");
            Set<String> roles = getusrroles();
            info.setRoles(roles);
            System.out.println("**************************>> ACCOUNT AUTHORIZATION IS SUCCESSFUL >>**************************");
        } else {
            return null;
        }
        return info;
    }

    private Set<String> getroles() {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        return sets;
    }

    private Set<String> getusrroles() {
        Set<String> set = new HashSet<>();
        set.add("user");
        return set;
    }

    //授权逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //判断用户名和密码 微信用户的token
        System.out.println("**************************>> DOGETAUTHENTICATIONINFO >>**************************");
//        String username = (String)authenticationToken.getPrincipal();
//        if(adminService.queryByadminid(username)){
//           return adminService.queryPwdByadminid(username)?:;
//        }
        String adminid = (String) authenticationToken.getPrincipal();
        if (authenticationToken instanceof MyToken) {
            if (userService.existswxid(adminid) == null) {
                return null;
            } else {
                //注意这里 md5连空都加密的 丧心病狂
                String str = new SimpleHash("md5", "").toHex();
//                System.out.println(str);
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(adminid, str, getName());
                return info;
            }
        } else if (authenticationToken instanceof UsernamePasswordToken) {
            if (adminService.queryAllFromAdmin(adminid) == null) {
                return null;
            } else {
                Admin admin = adminService.queryAllFromAdmin(adminid);
                SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(admin.getAdminid(), admin.getPwd(), ByteSource.Util.bytes(admin.getSalt()), getName());
                return info;
            }
        } else {
            return null;
        }
    }

    /**
     * 重写supports 使之支持自定义TOKEN
     */
    @Override
    public boolean supports(AuthenticationToken token) {

        System.out.println("this is support");
        return token instanceof UsernamePasswordToken || token instanceof MyToken;

    }
}
