package com.xm.sbdemo1.config;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class MyToken extends UsernamePasswordToken implements Serializable {

    private String username;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Object getPrincipal() {
        return this.username;
    }

    @Override
    public Object getCredentials() {
//        String str = "";
//        String newstr = new SimpleHash("md5",str).toHex();
        return "";
    }

    public MyToken(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "MyToken{" +
                "username='" + username + '\'' +
                '}';
    }

}


