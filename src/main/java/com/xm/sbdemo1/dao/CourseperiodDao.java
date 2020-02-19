package com.xm.sbdemo1.dao;


import com.xm.sbdemo1.pojo.Courseperiod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CourseperiodDao {

    List<Courseperiod> queryByCid(@Param("courseid") Long courseid);

    List<Courseperiod> queryAll();

    List<Courseperiod> queryByTopTime();
}


