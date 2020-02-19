package com.xm.sbdemo1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "award")
public class AwardConfig {

    @Value("${award.conaward}")
    private Integer conaward;

    @Value("${award.score}")
    private Integer score;

    @Value("${award.coursescore}")
    private Integer coursescore;

    public Integer getConaward() {
        return conaward;
    }

    public void setConaward(Integer conaward) {
        this.conaward = conaward;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCoursescore() {
        return coursescore;
    }

    public void setCoursescore(Integer coursescore) {
        this.coursescore = coursescore;
    }

    @Override
    public String toString() {
        return "AwardConfig{" +
                "conaward=" + conaward +
                ", score=" + score +
                '}';
    }
}
