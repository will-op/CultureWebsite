package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.AdminDao;
import com.xm.sbdemo1.pojo.Admin;
import com.xm.sbdemo1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin queryAllFromAdmin(String adminid) {

        return adminDao.queryAllFromAdmin(adminid);
    }

    @Override
    public boolean adminRegister(String adminid, String pwd, String salt) {
        int row = adminDao.adminRegister(adminid, pwd, salt);
        return row == 1;
    }
}
