package com.xm.sbdemo1.pojo;

/**
 * 用户的实体类
 */
public class User {


    private Long userid;

    private String wxid;

    private String ifadmin;

    private String wxnickname;

    private String sex;

    private Integer userscore;

//    private List<Course> courses;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getIfadmin() {
        return ifadmin;
    }

    public void setIfadmin(String ifadmin) {
        this.ifadmin = ifadmin;
    }

    public String getWxnickname() {
        return wxnickname;
    }

    public void setWxnickname(String wxnickname) {
        this.wxnickname = wxnickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserscore() {
        return userscore;
    }

    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", wxid='" + wxid + '\'' +
                ", wxnickname='" + wxnickname + '\'' +
                ", sex='" + sex + '\'' +
                ", userscore=" + userscore +
                '}';
    }
}
