package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分类详情的数据库接口
 */

@Mapper
@Component("categoryDao")//说是不确定那一层时使用该注解
public interface CategoryDao {

    List<Category> queryAll();

    int update(Category category);

    int add(Category category);

    int delete(@Param("categoryid") Long categoryid);

}
