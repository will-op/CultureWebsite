package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.CourseperiodDao;
import com.xm.sbdemo1.pojo.Courseperiod;
import com.xm.sbdemo1.service.CourseperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseperiodService")
public class CourseperiodServiceImpl implements CourseperiodService {

    @Autowired
    private CourseperiodDao courseperiodDao;

    @Override
    public List<Courseperiod> queryByCid(Long courseid) {
        return courseperiodDao.queryByCid(courseid);
    }

    @Override
    public List<Courseperiod> queryAll() {
        return courseperiodDao.queryAll();
    }

    @Override
    public List<Courseperiod> queryByTopTime() {
        return courseperiodDao.queryByTopTime();
    }
}
