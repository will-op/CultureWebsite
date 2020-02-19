package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程详情接口
 */

@Repository
@Mapper
public interface CourseDao {
    List<Course> queryByCategoryid(@Param("categoryid") Long categoryid);

    List<Course> collectKeyword(@Param("categoryid") Long categoryid);

    List<Course> queryUseKeyword(@Param("categoryid") Long categoryid, @Param("keyword") String keyword);

    List<Course> queryByTitle(@Param("title") String title);

    List<Course> queryByTitleSearch(@Param("title") String title);

    Course queryBytitletoclass(@Param("coursename") String coursename);

    List<Course> queryCourseByCourseid(@Param("courseid") Long courseid);

    int deleteByCourseid(@Param("courseid") Long courseid);

    int addCourse(Course course);

    int updatecourse(Course course);

    int joinOne(@Param("courseid") Long courseid);

    Course queryAllFromCourse(@Param("courseid") Long courseid);

    List<Course> searchFromCourse(@Param("title") String title);

    List<Course> searByObject(@Param("categoryid") Long categoryid, @Param("work") String work, @Param("keyword") String keyword, @Param("sortby") Long sortby);
}
