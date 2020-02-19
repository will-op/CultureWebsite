package com.xm.sbdemo1.pojo;

import java.util.List;

public class UserCollect {

    private Long usercollectid;

    private Long userid;

    private Long courseid;

    private List<Course> courses;

    public Long getUsercollectid() {
        return usercollectid;
    }

    public void setUsercollectid(Long usercollectid) {
        this.usercollectid = usercollectid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
