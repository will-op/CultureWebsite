package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.TeacherDao;
import com.xm.sbdemo1.pojo.Teacher;
import com.xm.sbdemo1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher queryTeacherByTeacherid(Long teacherid) {
        return teacherDao.queryTeacherByTeacherid(teacherid);
    }

    @Override
    public Teacher searchFromTeacher(String title) {
        return teacherDao.searchFromTeacher(title);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher) == 1;
    }

    @Override
    public boolean deleteTeacher(Long teacherid) {
        return teacherDao.deleteTeacher(teacherid) == 1;
    }

    @Override
    public boolean updateteacher(Teacher teacher) {
        return teacherDao.updateteacher(teacher) == 1;
    }
}
