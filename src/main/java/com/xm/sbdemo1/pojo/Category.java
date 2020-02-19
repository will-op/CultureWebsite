package com.xm.sbdemo1.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分类详情实体类
 */
public class Category implements Serializable {

    private Long categoryid;

    private String sortname;

    //一对多关系
    private List<Course> courses;

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
