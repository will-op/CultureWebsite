package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.CourseOfUser;

import java.util.List;

public interface CourseOfUserService {


    List<CourseOfUser> queryPurchasedByUserid(Long userid);

    boolean buyCourse(String courseperiodname, Long courseid, Long userid);

}
