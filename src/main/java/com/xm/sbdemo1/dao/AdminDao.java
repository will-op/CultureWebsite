package com.xm.sbdemo1.dao;


import com.xm.sbdemo1.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository//dao层专用注解？
@Mapper
public interface AdminDao {

    Admin queryAllFromAdmin(@Param("adminid") String adminid);

    int adminRegister(@Param("adminid") String adminid, @Param("pwd") String pwd, @Param("salt") String salt);
}
