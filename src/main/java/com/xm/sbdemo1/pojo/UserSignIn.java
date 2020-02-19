package com.xm.sbdemo1.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserSignIn {

    private Long signid;

    private Long userid;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signdate;

    private Integer continuedays;

    private Integer signaward;

    private String awardtype;

    private Integer finalaward;

    public Long getSignid() {
        return signid;
    }

    public void setSignid(Long signid) {
        this.signid = signid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getSigndate() {
        return signdate;
    }

    public void setSigndate(Date signdate) {
        this.signdate = signdate;
    }

    public Integer getContinuedays() {
        return continuedays;
    }

    public void setContinuedays(Integer continuedays) {
        this.continuedays = continuedays;
    }

    public Integer getSignaward() {
        return signaward;
    }

    public void setSignaward(Integer signaward) {
        this.signaward = signaward;
    }

    public String getAwardtype() {
        return awardtype;
    }

    public void setAwardtype(String awardtype) {
        this.awardtype = awardtype;
    }

    public Integer getFinalaward() {
        return finalaward;
    }

    public void setFinalaward(Integer finalaward) {
        this.finalaward = finalaward;
    }
}
