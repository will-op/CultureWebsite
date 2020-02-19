package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.constant.StatusCodeContent;
import com.github.pagehelper.PageInfo;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.*;
import com.xm.sbdemo1.service.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


/**
 * 这是分类详情的控制类 包括课程简介、关键词统计和搜索、课程详情
 */
@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

    //这里注入报错就是没有实现service接口 去实现
    @Autowired
    private CourseService courseService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HotSearchService hotSearchService;

    /**
     * @api {GET} /course/query/:categoryid 查看该类别下课程（categoryid）
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName categoryquerybyid
     * @apiDescription 查看该类别下课程
     * @apiParam (请求参数) {Number} categoryid
     * @apiParam (请求参数) {Number} currentPage
     * @apiParam (请求参数) {Number} pageSize
     * @apiParam (请求参数) {Object} session
     * @apiParamExample 拼接URL
     * {/course/query/1/}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "courseForCategory": {
     * "total": -1,
     * "list": [
     * {
     * "courseid": 1,
     * "title": "国画课",
     * "keyword": "国画",
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1500,
     * "categoryid": 1,
     * "teacherid": 1,
     * "courseintro": null,
     * "category": null
     * }
     * ],
     * "pageNum": 1,
     * "pageSize": 1,
     * "size": 1,
     * "startRow": 1,
     * "endRow": 1,
     * "pages": 1,
     * "prePage": 0,
     * "nextPage": 0,
     * "isFirstPage": true,
     * "isLastPage": true,
     * "hasPreviousPage": false,
     * "hasNextPage": false,
     * "navigatePages": 8,
     * "navigatepageNums": [
     * 1
     * ],
     * "navigateFirstPage": 1,
     * "navigateLastPage": 1
     * }
     * }
     */
    @RequestMapping("/query/{categoryid}")
    public JSONObject categoryquerybyid(@PathVariable("categoryid") Long categoryid,
                                        @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                        @RequestParam(value = "pageSize", defaultValue = "1") int pageSize) {


        HashMap<String, Object> map = new HashMap<>();
        PageInfo<Course> coursePageInfo = courseService.queryById(currentPage, pageSize, categoryid);
        map.put("courseForCategory", coursePageInfo);
//        JSONObject jsonObject = new JSONObject(map);

        return Result.success(coursePageInfo);
    }

    /**
     * @api {POST} /course/querybykeyword 点击关键词搜索（categoryid+keyword）
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName querybykeyword
     * @apiDescription 点击关键词搜索
     * @apiParam (请求体) {Object} Object
     * @apiParamExample 请求体示例
     * {
     * "categoryid":1,
     * "keyword":"国画"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "courseForKeyword": [
     * {
     * "courseid": null,
     * "title": null,
     * "keyword": "国画",
     * "totalnum": null,
     * "joined": null,
     * "price": null,
     * "categoryid": null,
     * "teacherid": null,
     * "courseintro": null,
     * "category": null
     * }
     * ]
     * }
     */
    @RequestMapping("/querybykeyword")
    public JSONObject querybykeyword(@RequestBody JSONObject object) {

        HashMap<String, Object> map = new HashMap<>();
        Long categoryid = object.getLong("categoryid");
        String keyword = object.getString("keyword");
        List<Course> courses = courseService.queryUseKeyword(categoryid, keyword);
//        map.put("KeywordForCategory",keywords);
//        JSONObject jsonObject = new JSONObject(map);

//        return new JSONObject(map);
        return Result.success(courses);
    }

    /**
     * @api {GET} /course/collectkeyword/:categoryid 类别下关键词
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName collectkeyword
     * @apiDescription 类别下关键词
     * @apiParam (请求体) {Number} categoryid
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */

    @RequestMapping("/collectkeyword/{categoryid}")
    public JSONObject collectkeyword(@PathVariable("categoryid") Long categoryid) {

        HashMap map = new HashMap();
        List<Course> courses = courseService.collectKeyword(categoryid);
        String[] keywords = new String[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            keywords[i] = courses.get(i).getKeyword();
        }

//        map.put("keywords",keywords);
//        return new JSONObject(map);
        return Result.success(keywords);
    }


    /**
     * @api {POST} /course/querybycourseid 查看课程详情
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName querybycourseid
     * @apiDescription 查看课程详情
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "courseid":1
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "course": {
     * "courseid": 1,
     * "title": "国画课",
     * "keyword": 国画,
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1600,
     * "categoryid": 1,
     * "teacherid": 1,
     * "courseintro": "好课",
     * "category": 1
     * }
     * <p>
     * }
     */
    @RequestMapping("/querybycourseid")
    public JSONObject querybycourseid(@RequestBody JSONObject object) {

//        HashMap<String,Object> map = new HashMap<>();
        //课程详情 评论 老师介绍 分三块查询
//        String title = object.getString("title");
        Long courseid = object.getLong("courseid");
        List<Course> courses = courseService.queryCourseByCourseid(courseid);
//        map.put("courses",courses);
//        return new JSONObject(map);
        return Result.success(courses);
    }

//这个接口可以报废

    /**
     * @api {POST} /course/query/title 模糊查询
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName searchbytitle
     * @apiDescription 模糊查询（教师、关键词、描述、标题）
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "title": "国画"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "title": "国画",
     * "detail": [
     * {
     * "courseid": null,
     * "title": "国画课",
     * "keyword": null,
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1500,
     * "categoryid": null,
     * "teacherid": 1,
     * "courseintro": null,
     * "category": null
     * },
     * {
     * "courseid": null,
     * "title": "国画课2",
     * "keyword": null,
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1500,
     * "categoryid": null,
     * "teacherid": 2,
     * "courseintro": null,
     * "category": null
     * }
     * ]
     * }
     */
    @RequestMapping("query/title")
    public JSONObject searchbytitle(@RequestBody JSONObject object) {

//        model.addAttribute("title",title);
        HashMap<String, Object> map = new HashMap<>();
        boolean Flag = false;
        boolean addFlag = false;
        String title = object.getString("title");
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

//        model2.addAttribute("keyword",null);
//        model.addAttribute("detail",list);
        map.put("addhotwords", Flag);
        map.put("addonetime", addFlag);
        map.put("title", title);
        map.put("detail", list);
        JSONObject jsonObject = new JSONObject(map);

        return jsonObject;
    }


    /**
     * @api {POST} /course/addcollect 用户添加收藏
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName addcollect
     * @apiDescription 用户添加收藏
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "courseid":1
     * "userid":1
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errorMsg": "收藏课程失败"
     * }
     */
    @RequestMapping("/addcollect")
    public JSONObject addcollect(@RequestBody JSONObject object) {

        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        Long courseid = object.getLong("courseid");
//        System.out.println(user.getUserid());
        List<UserCollect> list = userService.queryCollects(user.getUserid());
        for (UserCollect userCollect : list) {
            if (userCollect.getCourseid() == courseid) {
                throw new BasicException("course/addcollect", StatusCodeContent.COLLECT_COLLECTFAILURE);
            }
        }
        if (!userService.coursecollect(courseid, user.getUserid())) {
            throw new BasicException("course/addcollect", StatusCodeContent.COLLECT_COLLECTFAILURE);
        }

        return Result.success(StatusCodeContent.COLLECT_COLLECTSUCCESS);
    }

    /**
     * @api {POST} /course/ifcollect 判断已收藏
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName ifcollect
     * @apiDescription 判断已收藏
     * @apiParam (请求参数) {Object} session
     * @apiParamExample 请求参数示例
     * session=null
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {"object":{}}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/ifcollect")
    public JSONObject ifcollect(@RequestBody JSONObject object,
                                HttpSession session) {
//        HashMap map = new HashMap();
        boolean colFlag = false;//表示未所藏
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        Long courseid = object.getLong("courseid");
        List<UserCollect> list = userService.queryCollects(user.getUserid());
        for (UserCollect userCollect : list) {
            if (userCollect.getCourseid() == courseid) {
//                colFlag = true;
                throw new BasicException("course/ifcollect", "已收藏");
            }
        }
//        map.put("colFlag",colFlag);
        return Result.success(colFlag);

    }

    /**
     * @api {GET} /course/topteachers 热门导师热搜词
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName topteachers
     * @apiDescription 热门老师
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "popteachers": [
     * "陈老师"
     * ]
     * }
     */
    @RequestMapping("/topteachers")
    public JSONObject topteachers() {

        HashMap map = new HashMap();
        List<HotSearch> hotSearches = hotSearchService.queryPopTeacher();
        String[] popteachers = new String[hotSearches.size()];
        for (int i = 0; i < hotSearches.size(); i++) {
            popteachers[i] = hotSearches.get(i).getHotwords();
        }
//        map.put("popteachers",popteachers);
//        return new JSONObject(map);
        return Result.success(popteachers);
    }

    /**
     * @api {GET} /course/topworks 热门作品热搜词
     * @apiVersion 1.0.0
     * @apiGroup CourseController
     * @apiName topworks
     * @apiDescription 热门作品
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "popteachers": [
     * "国画"
     * ]
     * }
     */
    @RequestMapping("/topworks")
    public JSONObject topworks() {

        HashMap map = new HashMap();
        List<HotSearch> hotSearches = hotSearchService.queryPopWorks();
        String[] popworks = new String[hotSearches.size()];
        for (int i = 0; i < hotSearches.size(); i++) {
            popworks[i] = hotSearches.get(i).getHotwords();
        }
//        map.put("popteachers",popworks);
//        return new JSONObject(map);
        return Result.success(popworks);
    }

}
