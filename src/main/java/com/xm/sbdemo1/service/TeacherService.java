package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.Teacher;

public interface TeacherService {
    Teacher queryTeacherByTeacherid(Long teacherid);

    Teacher searchFromTeacher(String title);

    boolean addTeacher(Teacher teacher);

    boolean deleteTeacher(Long teacherid);

    boolean updateteacher(Teacher teacher);
}
