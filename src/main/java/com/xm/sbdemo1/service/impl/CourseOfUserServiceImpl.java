package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.CourseDao;
import com.xm.sbdemo1.dao.CourseOfUserDao;
import com.xm.sbdemo1.pojo.CourseOfUser;
import com.xm.sbdemo1.service.CourseOfUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("CsofuserService")
public class CourseOfUserServiceImpl implements CourseOfUserService {

    @Autowired
    private CourseOfUserDao courseOfUserDao;

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CourseOfUser> queryPurchasedByUserid(Long userid) {
        return courseOfUserDao.queryPurchasedByUserid(userid);
    }

    @Override
    public boolean buyCourse(String courseperiodname, Long courseid, Long userid) {

        Date buydate = new Date();
        Integer joinFlag = 0;
        int flag = courseOfUserDao.buyCourse(courseperiodname, courseid, userid, buydate);
        if (flag == 1) {
            joinFlag = courseDao.joinOne(courseid);
        }
        return (flag == 1 && joinFlag == 1);

    }

}
