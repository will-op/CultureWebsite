package com.xm.sbdemo1.pojo;

import java.io.Serializable;

public class Admin implements Serializable {

    private String adminid;

    private String pwd;

    private String salt;

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminid='" + adminid + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
