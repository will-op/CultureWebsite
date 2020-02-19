package com.xm.sbdemo1.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 课程详情实体类
 */
//过滤null值
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course implements Serializable {

    private Long courseid;

    private String title;

    private String keyword;

    private Long totalnum;

    private Long joined;

    private Integer price;

    private Long categoryid;

    private Long teacherid;

    private String courseintro;

    private String abstracts;

    private Date firstdate;

    //多对一关系
    private Category category;

    //一对多
    private List<Comment> comments;

    private List<Courseperiod> courseperiods;

    //pvp
    private Teacher teacher;


    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Long totalnum) {
        this.totalnum = totalnum;
    }

    public Long getJoined() {
        return joined;
    }

    public void setJoined(Long joined) {
        this.joined = joined;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCourseintro() {
        return courseintro;
    }

    public void setCourseintro(String courseintro) {
        this.courseintro = courseintro;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    public List<Courseperiod> getCourseperiods() {
        return courseperiods;
    }

    public void setCourseperiods(List<Courseperiod> courseperiods) {
        this.courseperiods = courseperiods;
    }
}
