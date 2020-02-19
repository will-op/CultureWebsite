package com.xm.sbdemo1.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.dao.CourseDao;
import com.xm.sbdemo1.pojo.Course;
import com.xm.sbdemo1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("DetailService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public PageInfo<Course> queryById(Integer currentPage, Integer pageSize, Long categoryid) {

        PageHelper.startPage(currentPage, pageSize);
        List<Course> courses = courseDao.queryByCategoryid(categoryid);
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        return pageInfo;
    }

    @Override
    public List<Course> collectKeyword(Long categoryid) {

        return courseDao.collectKeyword(categoryid);
    }

    @Override
    public List<Course> queryUseKeyword(Long categoryid, String keyword) {

        return courseDao.queryUseKeyword(categoryid, keyword);
    }

    @Override
    public List<Course> queryBytitle(String title) {
        return courseDao.queryByTitle(title);
    }

    @Override
    public List<Course> queryByTitleSearch(String title) {
        return courseDao.queryByTitleSearch(title);
    }

    @Override
    public Course queryBytitletoclass(String coursename) {
        return courseDao.queryBytitletoclass(coursename);
    }

    @Override
    public List<Course> queryCourseByCourseid(Long courseid) {
        return courseDao.queryCourseByCourseid(courseid);
    }

    @Override
    public boolean deleteByCourseid(Long courseid) {
        return courseDao.deleteByCourseid(courseid) == 1;
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDao.addCourse(course) == 1;
    }

    @Override
    public boolean updatecourse(Course course) {
        return courseDao.updatecourse(course) == 1;
    }

    @Override
    public Course queryAllFromCourse(Long courseid) {
        return courseDao.queryAllFromCourse(courseid);
    }

    @Override
    public List<Course> searchFromCourse(String title) {
        return courseDao.searchFromCourse(title);
    }
}
