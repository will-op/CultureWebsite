package com.xm.sbdemo1.dao;

import com.xm.sbdemo1.pojo.HotSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HotSearchDao {


    HotSearch queryHotWord(@Param("title") String title);

    int searchFromTeacher(@Param("title") String title);

    int addHotWords(@Param("title") String title, @Param("searchtimes") Long searchtimes, @Param("note") int note);

    int searchFromCourse(@Param("title") String title);

    int addOneToWords(@Param("title") String title);

    List<HotSearch> queryPopTeacher();

    List<HotSearch> queryPopWorks();
}
