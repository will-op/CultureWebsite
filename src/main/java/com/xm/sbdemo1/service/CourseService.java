package com.xm.sbdemo1.service;

import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.pojo.Course;
import org.apache.shiro.authz.annotation.RequiresRoles;

import java.util.List;

public interface CourseService {

    PageInfo<Course> queryById(Integer currentPage, Integer pageSize, Long categoryid);

    List<Course> collectKeyword(Long categoryid);

    List<Course> queryUseKeyword(Long categoryid, String keyword);

    List<Course> queryBytitle(String title);

    List<Course> queryByTitleSearch(String title);

    Course queryBytitletoclass(String coursename);

    List<Course> queryCourseByCourseid(Long courseid);

    @RequiresRoles(value = {"admin"})
    boolean deleteByCourseid(Long courseid);

    @RequiresRoles(value = {"admin"})
    boolean addCourse(Course course);

    @RequiresRoles(value = {"admin"})
    boolean updatecourse(Course course);

    Course queryAllFromCourse(Long courseid);

    List<Course> searchFromCourse(String title);
}
