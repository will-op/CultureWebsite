package com.xm.sbdemo1.service;

import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.pojo.Category;
import org.apache.shiro.authz.annotation.RequiresRoles;

import java.util.List;

/**
 * 分类接口
 */
public interface CategoryService {

    List<Category> queryAll();

    @RequiresRoles(value = {"admin"})
    boolean update(Category category);

    @RequiresRoles(value = {"admin"})
    int add(Category category);

    @RequiresRoles(value = {"admin"})
    boolean delete(Long categoryid);

    List<Category> queryAll(JSONObject object);


}
