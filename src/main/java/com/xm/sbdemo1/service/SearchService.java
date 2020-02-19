package com.xm.sbdemo1.service;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.pojo.Course;

public interface SearchService {
//    List<Course> searByObject(JSONObject object);

    PageInfo<Course> searByObject(int currentPage, int pageSize, JSONObject object);
}
