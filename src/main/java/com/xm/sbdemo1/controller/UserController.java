package com.xm.sbdemo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.config.AwardConfig;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.User;
import com.xm.sbdemo1.pojo.UserCollect;
import com.xm.sbdemo1.pojo.UserSignIn;
import com.xm.sbdemo1.service.CategoryService;
import com.xm.sbdemo1.service.CourseService;
import com.xm.sbdemo1.service.CourseperiodService;
import com.xm.sbdemo1.service.UserService;
import com.xm.sbdemo1.util.IdGenerator;
import com.xm.sbdemo1.util.ScoreCalculator;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 有关用户相应的控制器 包括登录、管理员验证、用户信息
 * 这是个毒瘤接口 建议重构重写 刚接触apidoc时无意define 造成该course/collect无法归入UserManagement
 */
//SessionAttributes这个注解不大会用 可以用于controller间的传值 但是页面不行
//@SessionAttributes(value={"adFlag","user"})
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CourseperiodService courseperiodService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AwardConfig awardConfig;

//    @RequestMapping("/logout")
//    public String logout(HttpSession session,Model model){
//        session.removeAttribute("username");
//        session.invalidate();
//        List<Category> list = categoryService.queryAll();
//        model.addAttribute("category",list);
//        return "main";
//    }

    //这里数据库要完善  应该再加一个用户详情表 还是单表 考虑下
    @RequestMapping("/detail")
    @ResponseBody
    public JSONObject userDetail() {

//        User user = (User)session.getAttribute("User");

//        List<User> list= userService.queryById(user.getCategoryid());
//        model.addAttribute("userdetail",user);
//这里更简便做法就是直接把session里的user传出去 后期再考虑  上面是正常逻辑
//        model.addAttribute("user",user);
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        user.setWxid(null);
        return Result.success(user);
    }


    /**
     * @api {GET} /user/showcollect/:userid/ 查看收藏
     * @apiVersion 0.0.1
     * @apiGroup UserController
     * @apiName showcollect
     * @apiDescription 查看收藏
     * @apiParam (请求体) {Number} userid
     * @apiParamExample 请求体示例
     * {/user/showcollect/1}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/showcollect")
    @ResponseBody
    public JSONObject showcollect() {
//        HashMap<String,Object> map = new HashMap<>();
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
        List<UserCollect> collects = userService.queryCollects(user.getUserid());
//        map.put("collects",collects);
//        JSONObject jsonObject = new JSONObject(map);
//        return new JSONObject(map);
        return Result.success(collects);
    }


    @RequestMapping("/judgesignin")
    @ResponseBody
    public JSONObject judgesignin(@RequestBody JSONObject object) {

        Map<String, Object> map = new LinkedHashMap<>();
        String awardtype = object.getString("awardtype");
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
//        Date signtoday = new Date("Thu Jun 22 22:12:10 2019");
        Calendar today = Calendar.getInstance();
        today.set(2019, Calendar.OCTOBER, 19, 22, 12, 10);
        Date signtoday = today.getTime();

        boolean judgeFlag = true;
        UserSignIn userSignIn = userService.querySignDate(user.getUserid(), awardtype);//kao lv wei kong de qingkuang

        Calendar testtime = Calendar.getInstance();
        testtime.setTime(userSignIn.getSigndate());
        Date testdate = testtime.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String todaystr = dateFormat.format(signtoday);
        String teststr = dateFormat.format(testdate);


        if (todaystr.equals(teststr)) {
            map.put("judgeFlag", judgeFlag); //已签到 judgeFlag = true
        } else {
            judgeFlag = false;
            map.put("judgeFlag", judgeFlag);//未签到 judgeFlag = false

        }
        return Result.success(map);
    }


    /**
     * @api {POST} /user/signin 用户签到
     * @apiVersion 0.0.1
     * @apiGroup UserController
     * @apiName 用户签到
     * @apiDescription 用户签到
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "awardtype":"签到",
     * "userid": 1
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "signFlag": true,
     * "addFlag": true
     * }
     */
    @RequestMapping("/signin")
    @ResponseBody
    public JSONObject signin(@RequestBody JSONObject object) {
        Map<String, Object> map = new LinkedHashMap<>();
        String awardtype = object.getString("awardtype");
        User user = (User) SecurityUtils.getSubject().getSession(true).getAttribute("User");
//        Date signtoday = new Date("Thu Jun 22 22:12:10 2019");
        Calendar today = Calendar.getInstance();
        today.set(2019, Calendar.OCTOBER, 19, 22, 12, 10);
        Date signtoday = today.getTime();

        boolean signFlag = false;
        boolean addFlag = false;
        UserSignIn userSignIn = userService.querySignDate(user.getUserid(), awardtype);//kao lv wei kong de qingkuang

        Calendar testtime = Calendar.getInstance();
        testtime.setTime(userSignIn.getSigndate());
        Date testdate = testtime.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String todaystr = dateFormat.format(signtoday);
        String teststr = dateFormat.format(testdate);


        if (todaystr.equals(teststr)) {
            map.put("signFlag", signFlag);
            map.put("addFlag", addFlag);
            return Result.success(map);
        }
        if (userSignIn == null) {
            signFlag = userService.signin(user.getUserid(), signtoday, 1, 0, awardtype, awardConfig.getScore());
            addFlag = userService.addscore(awardConfig.getScore(), user.getUserid());
        } else {
            ScoreCalculator sc = new ScoreCalculator(awardConfig, user.getUserscore(), userSignIn, today, awardtype);
            signFlag = userService.signin(user.getUserid(), signtoday, sc.getContinuedays(), sc.getAward(), sc.getType(), sc.getFinalaward());
            addFlag = userService.addscore(sc.getUserscore(), user.getUserid());
        }

        map.put("signFlag", signFlag);
        map.put("addFlag", addFlag);
//        return new JSONObject(map);
        return Result.success(map);
    }

    /**
     * 以下例子有利于你理解积分算法
     */
//    public static void main(String[] args) {
////        Date date = new Date("Thu Jun 21 22:14:10 2019");
////        Date signdate = new Date("Thu Jun 23 22:14:11 2019");
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        System.out.println(dateFormat.format(signdate).equals(dateFormat.format(date)));//测试是否超过当天不能重复签到
//
//        UserSignIn signIn = new UserSignIn();
//        Calendar calendar = Calendar.getInstance();
//        Calendar calendar1 = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//        Calendar calendar3 = Calendar.getInstance();
//        Date date2 = new Date("Thu Jun 21 22:14:10 2019");
//        calendar2.setTime(date2);
//        calendar.set(2019,Calendar.JUNE,22,22,14,10);
//        calendar1.set(2019,Calendar.JUNE,22,22,14,10);
//        Date date = calendar.getTime();
//        Date date1 = calendar1.getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//        String today1= dateFormat.format(date);
//        String day = dateFormat.format(date1);
//        calendar.add(Calendar.DATE,9);
//        System.out.println(calendar.getTime());
//        System.out.println(date);
//        System.out.println(today1);
//        System.out.println(today1.equals(day));
//        System.out.println(calendar2.getTime());
//        System.out.println(calendar3.getTime());
//        String[] strings = new String[7];
//        for(int i=0;i<7;i++){
//            calendar.add(Calendar.DAY_OF_MONTH,1);
//            date = calendar.getTime();
//            strings[i] = dateFormat.format(date);
//        }
//        for(int i=0;i<7;i++){
//        System.out.println(strings[i]);}
//    }
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public String test() {
//
//        return "223";
//    }
    public static void main(String[] args) throws InterruptedException {

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
//
//        for (int i = 0; i < 30 ; i++) {
//            Date date = new Date();
//            Random random = new Random();
//            String pre = dateFormat.format(date);
//            String suf = String.valueOf(random.nextInt(999-100+1)+100);
//            StringBuilder builder = new StringBuilder(pre);
//            String id = String.valueOf(builder.append(suf));
//            Long newid = Long.valueOf(id);
//            System.out.println(newid);
//        }
        for (int i = 0; i < 10; i++) {
            IdGenerator generator = new IdGenerator();
            System.out.println(generator.teacheridGenerator());
//            System.out.println(generator.adminidGenerator());

        }

    }


}


