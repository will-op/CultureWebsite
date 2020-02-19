package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.CourseOfUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface CourseOfUserDao {

    List<CourseOfUser> queryPurchasedByUserid(@Param("userid") Long userid);

    int buyCourse(@Param("courseperiodname") String courseperiodname, @Param("courseid") Long courseid, @Param("userid") Long userid, @Param("buydate") Date buydate);

}
