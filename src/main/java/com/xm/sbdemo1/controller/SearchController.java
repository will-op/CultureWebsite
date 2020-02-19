package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Course;
import com.xm.sbdemo1.service.CourseService;
import com.xm.sbdemo1.service.HotSearchService;
import com.xm.sbdemo1.service.SearchService;
import com.xm.sbdemo1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HotSearchService hotSearchService;

    @Autowired
    private CourseService courseService;


    /**
     * @api {POST} /search/basicSearch basicSearch
     * @apiVersion 0.0.1
     * @apiGroup SearchController
     * @apiName basicSearch
     * @apiDescription 查询模块（分类id、老师名、课程名、关键词、最新最热）
     * @apiParam (请求参数) {Number} currentPage
     * @apiParam (请求参数) {Number} pageSize
     * @apiParamExample 请求参数示例
     * pageSize=1&currentPage=1(默认都为1，需要传值）
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {"object":{}}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/basicSearch")
    public JSONObject basicSearch(@RequestBody JSONObject object,
                                  @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                  @RequestParam(value = "pageSize", defaultValue = "1") int pageSize) {

//        HashMap<String,Object> map = new HashMap<>();
//        HashMap<String,Object> hotwords = new HashMap<>();
        boolean Flag = false;
        boolean addFlag = false;
        PageInfo<Course> coursePageInfo = searchService.searByObject(currentPage, pageSize, object);

        //添加热搜
        String title = object.getString("work");
        if (title != null) {
            List<Course> list = courseService.queryByTitleSearch(title);
            //新词
            if (hotSearchService.queryHotWord(title) == null) {
                //判断是老师1还是摘要2
                if (teacherService.searchFromTeacher(title) != null) {
                    Flag = hotSearchService.addHotWords(title, 1L, 1);
                } else if (courseService.searchFromCourse(title) != null) {
                    Flag = hotSearchService.addHotWords(title, 1L, 2);
                }
            } else {
                //旧词+1
                addFlag = hotSearchService.addOneToWords(title);
            }
        }
        System.out.println(addFlag);
        System.out.println(Flag);

//        map.put("result",coursePageInfo);

//        return new JSONObject(map);
        return Result.success(coursePageInfo);
    }


}
