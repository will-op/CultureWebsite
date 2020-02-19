package com.xm.sbdemo1.dao;


import com.xm.sbdemo1.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherDao {

    Teacher queryTeacherByTeacherid(@Param("teacherid") Long teacherid);

    Teacher searchFromTeacher(@Param("title") String title);

    int addTeacher(Teacher teacher);

    int deleteTeacher(@Param("teacherid") Long teacherid);

    int updateteacher(Teacher teacher);
}
