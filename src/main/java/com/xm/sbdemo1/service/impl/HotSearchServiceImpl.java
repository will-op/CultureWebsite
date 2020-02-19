package com.xm.sbdemo1.service.impl;

import com.xm.sbdemo1.dao.HotSearchDao;
import com.xm.sbdemo1.pojo.HotSearch;
import com.xm.sbdemo1.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("HotSearchService")
public class HotSearchServiceImpl implements HotSearchService {

    @Autowired
    private HotSearchDao hotSearchDao;


    @Override
    public HotSearch queryHotWord(String title) {
        return hotSearchDao.queryHotWord(title);
    }

    @Override
    public boolean searchFromTeacher(String title) {
        return hotSearchDao.searchFromTeacher(title) == 1;
    }

    @Override
    public boolean addHotWords(String title, Long searchtimes, int note) {
        return hotSearchDao.addHotWords(title, searchtimes, note) == 1;
    }

    @Override
    public boolean searchFromCourse(String title) {
        return hotSearchDao.searchFromCourse(title) == 1;
    }

    @Override
    public boolean addOneToWords(String title) {
        return hotSearchDao.addOneToWords(title) == 1;
    }

    @Override
    public List<HotSearch> queryPopTeacher() {
        return hotSearchDao.queryPopTeacher();
    }

    @Override
    public List<HotSearch> queryPopWorks() {
        return hotSearchDao.queryPopWorks();
    }
}
