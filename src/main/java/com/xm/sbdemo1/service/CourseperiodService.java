package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.Courseperiod;

import java.util.List;

public interface CourseperiodService {
    List<Courseperiod> queryByCid(Long courseid);

    List<Courseperiod> queryAll();

    List<Courseperiod> queryByTopTime();

}
