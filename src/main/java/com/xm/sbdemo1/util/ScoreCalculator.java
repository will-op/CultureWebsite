package com.xm.sbdemo1.util;

import com.xm.sbdemo1.config.AwardConfig;
import com.xm.sbdemo1.pojo.UserSignIn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 积分计算器
 * 由于springboot的特性 controler之外无法自动注入（这玩意不让自动注入啊 很无奈）
 * 所以积分配置需要在控制器中注入并传入积分计算器中
 * 由于calendar的特性所以直接用可以免除不少麻烦 免去考虑大小月啥啥的
 * 主要算法即calendar与date类型相互转换 数据类型请参考本数据库表设计
 * 获取上一次签到时间（年月日）与此次签到时间（calendar转date）比较
 * 若连续签到则获得奖励 否则连续签到天数置1
 */

public class ScoreCalculator {


    private Long userid;

    private String type;

    private Integer userscore;

    private Integer award;//zhe ge xie pei zhi wen jian

    private Integer finalaward;

    private Date predate;

    private Boolean continueFlag;

    private Integer continuedays;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getUserscore() {
        return userscore;
    }

    public void setUserscore(Integer userscore) {
        this.userscore = userscore;
    }

    public Integer getAward() {
        return award;
    }

    public void setAward(Integer award) {
        this.award = award;
    }

    public Integer getFinalaward() {
        return finalaward;
    }

    public void setFinalaward(Integer finalaward) {
        this.finalaward = finalaward;
    }

    public Date getPredate() {
        return predate;
    }

    public void setPredate(Date predate) {
        this.predate = predate;
    }

    public Boolean getContinueFlag() {
        return continueFlag;
    }

    public Integer getContinuedays() {
        return continuedays;
    }

    public void setContinuedays(Integer continuedays) {
        this.continuedays = continuedays;
    }

    public void setContinueFlag(Boolean continueFlag) {
        this.continueFlag = continueFlag;
    }


    public ScoreCalculator(AwardConfig awardConfig, Integer userscore, UserSignIn userSignIn, Calendar signtoday, String type) {

        Calendar signlimit = Calendar.getInstance();
        signlimit.setTime(userSignIn.getSigndate());
        signlimit.add(Calendar.DATE, 1);
//        signlimit.set(Calendar.HOUR_OF_DAY,23);
//        signlimit.set(Calendar.MINUTE,59);
//        signlimit.set(Calendar.SECOND,59);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date today = signtoday.getTime();
        Date lasttime = signlimit.getTime();
        String todaystr = dateFormat.format(today);
        String lasttimestr = dateFormat.format(lasttime);

//        System.out.println(dateFormat.format(signdate).equals(dateFormat.format(date)))
//        double hourgap = ((nowdate.getTime())*1.0-userSignIn.getSigndate().getTime())/1000/3600;
//        double daygap = ((nowdate.getTime())*1.0-userSignIn.getSigndate().getTime())/1000/3600/24;
        int scoreafteraward = 0;
        int award = 0;
        boolean continueFlag = false;
        int continuedays = 0;
        int finalaward = 0;
        if (todaystr.equals(lasttimestr)) {
            continueFlag = true;
            continuedays = userSignIn.getContinuedays() + 1;

        } else {
            continuedays = 1;
        }
        if (continuedays <= 7) {
            award = (continuedays - 1) * (awardConfig.getConaward());

        } else {
            award = 6 * awardConfig.getConaward();
        }
        finalaward = awardConfig.getScore() + award;
        scoreafteraward = userscore + finalaward;
//        scoreafteraward = score+award;
        this.userid = userSignIn.getUserid();
        this.userscore = scoreafteraward;
        this.continuedays = continuedays;
        this.award = award;
        this.finalaward = finalaward;
        this.continueFlag = continueFlag;
        this.predate = userSignIn.getSigndate();
        this.type = type;
    }

//    public ScoreCalculator(AwardConfig awardConfig, User user,){
//
//        if(type.equals("签到")){
//            this.userid=userid;
//            this.userscore = userscore+5;
//            this.type = type;
//        }
//
//    }

    @Override
    public String toString() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return "ScoreCalculator{" +
                "userid=" + userid +
                ", type='" + type + '\'' +
                ", userscore=" + userscore +
                ", award=" + award +
                ", predate=" + predate +
                ", continueFlag=" + continueFlag +
                ", continuedays=" + continuedays +
                '}';
    }
}
