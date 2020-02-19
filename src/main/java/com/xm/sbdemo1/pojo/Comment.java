package com.xm.sbdemo1.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comment {

    private Long commentid;

    private Long userid;

    private Long courseid;

    private String coursecomments;

    private User user;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date answertime;

    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
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

    public String getCoursecomments() {
        return coursecomments;
    }

    public void setCoursecomments(String coursecomments) {
        this.coursecomments = coursecomments;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
