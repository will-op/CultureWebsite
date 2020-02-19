package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Category;
import com.xm.sbdemo1.pojo.Courseperiod;
import com.xm.sbdemo1.service.CategoryService;
import com.xm.sbdemo1.service.CourseService;
import com.xm.sbdemo1.service.CourseperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 这是主界面的控制类
 * 类别展示
 * 即将到来
 */


@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

//构造器注入  注入属性为必选
//通过构造器注入---begin
//     private JavaMailSender javaMailSender;
//
//     @Autowired
//     public AccountEmailServiceImpl(JavaMailSender javaMailSender){
//        this.javaMailSender = javaMailSender;
//     }
// 通过构造器注入---end

    //setter注入 注入属性为可选
//   通过set方法注入---begin
//     private JavaMailSender javaMailSender;
//     @Autowired
//     public void setJavaMailSender(JavaMailSender javaMailSender){
//               this.javaMailSender = javaMailSender;
//           }
//    通过set方法注入---end


    //这是filed注入 是不建议使用的 但是比较简洁
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CourseperiodService courseperiodService;

    @Autowired
    private CourseService courseService;


//          @ModelAttribute("adFlag")boolean adFlag   冲向取值

//        //model.containsAttribute返回的结果。内容只要存在即为ture，不适合用在传值
//        boolean adminFlag = model.containsAttribute(user.getIfadmin());
//        //重定向的接受值
//        model.addAttribute("ifadmin",adFlag);


    /**
     * @api {GET} /category/main 分类信息
     * @apiVersion 0.0.1
     * @apiGroup CategoryController
     * @apiName main
     * @apiDescription 分类信息
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "categories": [
     * {
     * "categoryid": 1,
     * "sortname": "国画",
     * "courses": null
     * },
     * {
     * "categoryid": 2,
     * "sortname": "油画",
     * "courses": null
     * },
     * {
     * "categoryid": 3,
     * "sortname": "水彩",
     * "courses": null
     * },
     * {
     * "categoryid": 4,
     * "sortname": "素描",
     * "courses": null
     * },
     * {
     * "categoryid": 8,
     * "sortname": "测试",
     * "courses": null
     * }
     * ]
     * }
     */
    @RequestMapping("/main")
    public JSONObject main() {

        try {
//        HashMap<String,Object> map = new HashMap<>();
            List<Category> list = categoryService.queryAll();
//        map.put("categories", list);
//        JSONObject jsonObject = new JSONObject(map);
            return Result.success(list);
//        return new JSONObject(map);
        } catch (Exception e) {
            throw new BasicException(500, "/category/main");
        }


    }

    /**
     * @api {GET} /category/coursecoming 即将开始
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName 即将开始
     * @apiDescription 即将开始
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "coursecoming": [
     * {
     * "id": null,
     * "ctitle": "国画课2",
     * "cperiod": "第二课时",
     * "cid": 2,
     * "timegap": "61小时后开始"
     * },
     * {
     * "id": null,
     * "ctitle": "油画课",
     * "cperiod": "第三课时",
     * "cid": 3,
     * "timegap": "68小时后开始"
     * },
     * {
     * "id": null,
     * "ctitle": "国画课",
     * "cperiod": "第一课时",
     * "cid": 1,
     * "timegap": "109小时后开始"
     * }
     * ]
     * }
     */
    @RequestMapping("/coursecoming")
    public JSONObject coursecoming() {
//        HashMap<String,Object> map = new HashMap<>();
        List<Courseperiod> courseperiods = courseperiodService.queryByTopTime();
        if (courseperiods.size() == 0) {
//            map.put("nocoursecoming","nocoursecoming");
            throw new BasicException("/category/coursecoming ", "nocoursecoming");
        } else {
//            Date[] begintime = new Date[courseperiods.size()];
            long hours;
            long minutes;
            Date nowtime = new Date();

            for (Courseperiod courseperiod : courseperiods) {
                //            begintime[i] = courseperiods.get(i).getBegintime();
                long gap = courseperiod.getBegintime().getTime() - nowtime.getTime();
                hours = gap / 1000 / 3600;
                long temp = gap % (1000 * 3600);
                minutes = temp / 1000 / 60;
                if (hours > 1) {
                    //                periodPojos[i].setTimegap(hours + "小时后开始");
                    courseperiod.setTimegap(hours + "小时后开始");
                } else if (hours == 0) {
                    //                periodPojos[i].setTimegap(minutes + "分钟后开始");
                    courseperiod.setTimegap(minutes + "分钟后开始");
                }
            }
//            map.put("coursecoming",courseperiods);

        }
        return Result.success(courseperiods);


    }


}
