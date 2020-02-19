package com.xm.sbdemo1.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Courseperiod implements Serializable {

    private Long courseperiodid;

    private String courseperiodname;

    private Long courseid;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begintime;

    private Course course;

    private Teacher teacher;

    private String timegap;

    public Long getCourseperiodid() {
        return courseperiodid;
    }

    public void setCourseperiodid(Long courseperiodid) {
        this.courseperiodid = courseperiodid;
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

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTimegap() {
        return timegap;
    }

    public void setTimegap(String timegap) {
        this.timegap = timegap;
    }
}
