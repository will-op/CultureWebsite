package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.pojo.UserCollect;
import com.xm.sbdemo1.pojo.UserSignIn;

import java.util.Date;
import java.util.List;

public interface UserService {

    User existswxid(String wxid);

    boolean regist(Long userid, String wxid, String wxnickname, String sex);

    boolean coursecollect(Long courseid, Long userid);

    List<UserCollect> queryCollects(Long userid);

    boolean signin(Long userid, Date signdate, Integer continuedays, Integer award, String awardtype, Integer finalaward);

    User queryByUserid(Long userid);

    UserSignIn querySignDate(Long userid, String awardtype);

    boolean addscore(Integer score, Long userid);
}
