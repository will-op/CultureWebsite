package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.Admin;

public interface AdminService {

    Admin queryAllFromAdmin(String adminid);

    boolean adminRegister(String adminid, String pwd, String salt);
}
