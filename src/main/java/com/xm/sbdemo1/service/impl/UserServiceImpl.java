package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.UserDao;
import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.pojo.UserCollect;
import com.xm.sbdemo1.pojo.UserSignIn;
import com.xm.sbdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User existswxid(String wxid) {
        return userDao.existswxid(wxid);
    }

    @Override
    public boolean regist(Long userid, String wxid, String wxnickname, String sex) {
        return userDao.regist(userid, wxid, wxnickname, sex) == 1;
    }

    @Override
    public boolean coursecollect(Long courseid, Long userid) {
        return userDao.coursecollect(courseid, userid) == 1;
    }


    @Override
    public List<UserCollect> queryCollects(Long userid) {
        return userDao.queryCollects(userid);
    }

    @Override
    public boolean signin(Long userid, Date signdate, Integer continuedays, Integer award, String awardtype, Integer finalaward) {
        return userDao.signin(userid, signdate, continuedays, award, awardtype, finalaward) == 1;
    }

    @Override
    public User queryByUserid(Long userid) {
        return userDao.queryByUserid(userid);
    }

    @Override
    public UserSignIn querySignDate(Long userid, String awardtype) {
        return userDao.querySignDate(userid, awardtype);
    }

    @Override
    public boolean addscore(Integer score, Long userid) {
        return userDao.addscore(score, userid) == 1;
    }
}
