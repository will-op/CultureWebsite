package com.xm.sbdemo1.service;

import com.xm.sbdemo1.pojo.HotSearch;

import java.util.List;

public interface HotSearchService {


    HotSearch queryHotWord(String title);

    boolean searchFromTeacher(String title);

    boolean addHotWords(String title, Long searchtimes, int note);

    boolean searchFromCourse(String title);

    boolean addOneToWords(String title);

    List<HotSearch> queryPopTeacher();

    List<HotSearch> queryPopWorks();
}
