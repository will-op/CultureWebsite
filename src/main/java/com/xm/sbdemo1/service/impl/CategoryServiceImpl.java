package com.xm.sbdemo1.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.dao.CategoryDao;
import com.xm.sbdemo1.pojo.Category;
import com.xm.sbdemo1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类详情接口的实现类
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    //这里如果dao注入失败
    // I   启动类加mapperscan注解指向dao包
    // II  dao接口需要加@Repository和@Mapper
    // III dao接口加@Mapper和@@Component("xxDao")
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> queryAll() {
        return categoryDao.queryAll();
    }

    @Override
    public boolean update(Category category) {
        return categoryDao.update(category) == 1;
    }

    @Override
    public int add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public boolean delete(Long categoryid) {
        return categoryDao.delete(categoryid) == 1;
    }

    @Override
    public List<Category> queryAll(JSONObject object) {
        return null;
    }

    ;

}
