package com.xm.sbdemo1.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.dao.CourseDao;
import com.xm.sbdemo1.pojo.Course;
import com.xm.sbdemo1.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SearchService")
public class SearchServiceImpl implements SearchService {


    @Autowired
    private CourseDao courseDao;

    //这里实现重载 去调用dao层 mybatis有动态sql 有机会试下
//    @Override
//    public List<Course> searByObject(JSONObject object) {
//        Long categoryid = object.getLong("categoryid");
//        String work = object.getString("work");
//        String title = object.getString("title");
//        String teachername = object.getString("teachername");
//        String keyword = object.getString("keyword");
//
//        return courseDao.searByObject(categoryid,work,keyword);
//    }

    @Override
    public PageInfo<Course> searByObject(int currentPage, int pageSize, JSONObject object) {

        Long categoryid = object.getLong("categoryid");
        String work = object.getString("work");
        String keyword = object.getString("keyword");
        Long sortby = object.getLong("sortby");//最新0 最热1
        PageHelper.startPage(currentPage, pageSize);
        List<Course> courses = courseDao.searByObject(categoryid, work, keyword, sortby);
        PageInfo<Course> coursePageInfo = new PageInfo<>(courses);


        return coursePageInfo;
    }
}
