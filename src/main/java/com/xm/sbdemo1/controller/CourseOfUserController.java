package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.constant.StatusCodeContent;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Course;
import com.xm.sbdemo1.pojo.CourseOfUser;
import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.service.CommentService;
import com.xm.sbdemo1.service.CourseOfUserService;
import com.xm.sbdemo1.service.CourseService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/usercourse")
@CrossOrigin
public class CourseOfUserController {

    @Autowired
    private CourseOfUserService courseOfUserService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CommentService commentService;


    /**
     * @api {POST} /usercourse/viewpurchased 查看已购买课程
     * @apiVersion 0.0.1
     * @apiGroup UserController
     * @apiName courseofuser
     * @apiDescription 查看已购买课程
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "userid": 1
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "courseOfUsers": [
     * {
     * "courseofuserid": null,
     * "userid": 1,
     * "coursename": null,
     * "courseid": 2,
     * "buydate": "2019-06-02 11:05:32",
     * "courses": [
     * {
     * "courseid": null,
     * "title": "国画课2",
     * "keyword": null,
     * "totalnum": null,
     * "joined": null,
     * "price": null,
     * "categoryid": null,
     * "teacherid": null,
     * "courseintro": null,
     * "category": null,
     * "comments": null,
     * "teacher": null
     * }
     * ]
     * },
     * {
     * "courseofuserid": null,
     * "userid": 1,
     * "coursename": null,
     * "courseid": 1,
     * "buydate": "2019-06-02 11:49:31",
     * "courses": [
     * {
     * "courseid": null,
     * "title": "国画课",
     * "keyword": null,
     * "totalnum": null,
     * "joined": null,
     * "price": null,
     * "categoryid": null,
     * "teacherid": null,
     * "courseintro": null,
     * "category": null,
     * "comments": null,
     * "teacher": null
     * }
     * ]
     * }
     * ]
     * }
     */
    @RequestMapping("/viewpurchased")
    public JSONObject viewpurchased() {

//        User user = (User)session.getAttribute("User");
//        Long userid = user.getUserid();

        HashMap map = new HashMap();
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        List<CourseOfUser> courseOfUsers = courseOfUserService.queryPurchasedByUserid(user.getUserid());

//        map.put("courseOfUsers",courseOfUsers);

        return Result.success(courseOfUsers);

    }


    /**
     * @api {POST} /usercourse/coursepurchase 购买课程
     * @apiVersion 0.0.1
     * @apiGroup UserController
     * @apiName coursepurchase
     * @apiDescription 购买课程
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "courseid": 1,
     * "userid": 1,
     * "period": [
     * "测试1",
     * "测试二",
     * "测试三"
     * ]
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errorMsg": "购买课程成功"
     * }
     */
    @RequestMapping(value = "/coursepurchase")
    public JSONObject coursepurchase(@RequestBody JSONObject object
    ) {

//        User user = (User)session.getAttribute("User");
//        Long userid = user.getUserid();//这里报过空指针异常 可能与session有关

        //这里要理解  废了好大劲
        //不要在传参中加Map 会出错的
        HashMap<String, Object> map = new HashMap<>();
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        List periods = object.getJSONArray("period");
        Long courseid = object.getLong("courseid");

        List<CourseOfUser> courseOfUsers = courseOfUserService.queryPurchasedByUserid(user.getUserid());
        //调试时数据库出现自增不连续 truncate table 表名 删数据重置自增
        //先判断是否满员 再判断list是否为空 再判断是否重复购买
        Course course = courseService.queryAllFromCourse(courseid);
        if (!(course.getJoined().equals(course.getTotalnum()))) {
            if (courseOfUsers.size() == 0) {
                for (Object period : periods) {
                    boolean Flag = courseOfUserService.buyCourse((String) period, courseid, user.getUserid());
                    if (!Flag) {
//                        map.put("errorMsg", StatusCodeContent.USER_BUYFAILURE);
//                        return new JSONObject(map);
                        throw new BasicException("/usercourse/coursepurchase", StatusCodeContent.USER_BUYFAILURE);
                    }
                }
//            map.put("errorMsg",StatusCodeContent.USER_BUYSUCCESS);
            } else {
                for (CourseOfUser courseOfUser : courseOfUsers) {
                    Long nowcoursename = courseOfUser.getCourseid();
                    for (int j = 0; j < periods.size(); j++) {
                        if (nowcoursename.equals(courseid)) {
//                            map.put("errorMsg", StatusCodeContent.USER_BUYFAILURE);
//                            return new JSONObject(map);
                            throw new BasicException("/usercourse/coursepurchase", StatusCodeContent.USER_BUYFAILURE);
                        }
                    }
                }
                for (Object period : periods) {
                    boolean Flag = courseOfUserService.buyCourse((String) period, courseid, user.getUserid());
                    if (!Flag) {
                        throw new BasicException("/usercourse/coursepurchase", StatusCodeContent.USER_BUYFAILURE);
                    }
                }
            }
            return Result.success(StatusCodeContent.USER_BUYSUCCESS);
        } else {
            throw new BasicException("/usercourse/coursepurchase", StatusCodeContent.USER_BUYFAILURE);
        }

//        return new JSONObject(map);
    }


    /**
     * @api {GET} /usercourse/test 测试
     * @apiVersion 0.0.1
     * @apiGroup CourseOfUserController
     * @apiName test
     * @apiDescription 测试
     * @apiSuccess (响应结果) {String} response
     * @apiSuccessExample 响应结果示例
     * "DSB8F5"
     */
    @RequestMapping("/test")
//    @RequiresRoles(value={"admin","user"},logical = Logical.OR)
    public String test() {

        System.out.println("checkroles success");
        return "success";
    }

}
