package com.xm.sbdemo1.pojo;

import java.util.Date;
import java.util.List;

//@JsonIgnoreProperties(value = {"handler"})
public class CourseOfUser {

    private Long courseofuserid;

    private Long userid;

    private String courseperiodname;

    private Long courseid;

    private Date buydate;

    private List<Course> courses;

    public Long getCourseofuserid() {
        return courseofuserid;
    }

    public void setCourseofuserid(Long courseofuserid) {
        this.courseofuserid = courseofuserid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getCourseperiodname() {
        return courseperiodname;
    }

    public void setCourseperiodname(String courseperiodname) {
        this.courseperiodname = courseperiodname;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public Date getBuydate() {
        return buydate;
    }

    //json返回值时差问题
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
