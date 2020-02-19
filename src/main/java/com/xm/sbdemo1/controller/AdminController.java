package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.constant.StatusCodeContent;
import com.xm.sbdemo1.exceptionhandle.BasicException;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Admin;
import com.xm.sbdemo1.pojo.Category;
import com.xm.sbdemo1.pojo.Course;
import com.xm.sbdemo1.pojo.Teacher;
import com.xm.sbdemo1.service.CategoryService;
import com.xm.sbdemo1.service.CourseService;
import com.xm.sbdemo1.service.CourseperiodService;
import com.xm.sbdemo1.service.TeacherService;
import com.xm.sbdemo1.util.IdGenerator;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {


    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseperiodService courseperiodService;


    /**
     * @api {POST} /admin/categoryupdate 更新分类
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName update
     * @apiDescription 更新分类
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "categories": [
     * {
     * "categoryid":1,
     * "sortname": "国画"
     * },
     * {
     * "categoryid": 2,
     * "sortname": "油画"
     * },
     * {
     * "categoryid": 3,
     * "sortname": "水彩"
     * },
     * {
     * "categoryid": 4,
     * "sortname": "素描画"
     * }
     * ]
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errorMsg": "更新类别成功"
     * }
     */
    @RequestMapping("/categoryupdate")
    @ResponseBody
    public JSONObject categoryupdate(@RequestBody JSONObject object) throws Exception {

        //fastjson 这玩意慎用  不知道他在想啥 能换快换
        //注意传进来的本来就是一个jsonarray
//        System.out.println(category);
//        boolean sucFlag = categoryService.update(category);
//        List<Category> categories = new ArrayList<Category>();
        //这里有没有更快的算法或者解决办法
        HashMap map = new HashMap();

        try {
            //这里裁剪字符串 太恶心 总之传进来的json数组必须是categories开头
            String str = object.toJSONString();
            String str1 = str.substring(14, str.length() - 1);
            List<Category> categoryList = JSONObject.parseArray(str1, Category.class);
            for (Category category : categoryList) {
                boolean sucFlag = categoryService.update(category);
                if (!sucFlag) {
                    throw new BasicException("/admin/categoryupdate", StatusCodeContent.ADMIN_UPDATECATEGORY_UPDATEFALURE);
//                    map.put("errorMsg", StatusCodeContent.ADMIN_UPDATECATEGORY_UPDATEFALURE);
//                    return new JSONObject(map);
                }
            }
//            map.put("errorMsg", StatusCodeContent.ADMIN_UPDATECATEGORY_UPDATESUCCESS);
            return Result.success(StatusCodeContent.ADMIN_UPDATECATEGORY_UPDATESUCCESS);

//            return new JSONObject(map);
        } catch (AuthorizationException e) {
//            e.printStackTrace();
//            map.put("errorMsg",StatusCodeContent.ACCOUNT_NO_AUTHORITY);
//            return new JSONObject(map);
            throw new BasicException("/admin/categoryupdate", StatusCodeContent.ACCOUNT_NO_AUTHORITY);
        } catch (NullPointerException ne) {
            throw new BasicException("/admin/categoryupdate", "空指针");
        } catch (Exception e) {
            throw new BasicException(500, "/admin/categoryupdate");
        }

    }


    /**
     * @api {POST} /admin/categoryadd 增加分类
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName categoryadd
     * @apiDescription 增加分类
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "sortname":"测试"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errorMsg": "添加类别成功"
     * }
     */
    @RequestMapping("/categoryadd")
    @ResponseBody
    public JSONObject categoryadd(@RequestBody JSONObject object) {

        Category category = object.toJavaObject(Category.class);
//        HashMap map = new HashMap();

        try {
            boolean sucFlag = categoryService.add(category) == 1;

            if (sucFlag) {
//                map.put("errorMsg", StatusCodeContent.ADMIN_ADDCATEGORY_ADDSUCCESS);
//                return new JSONObject(map);
                return Result.success(StatusCodeContent.ADMIN_ADDCATEGORY_ADDSUCCESS);
            }
//            map.put("errorMsg", StatusCodeContent.ADMIN_ADDCATEGORY_ADDFALURE);
            throw new BasicException("/admin/categoryadd", StatusCodeContent.ADMIN_ADDCATEGORY_ADDFALURE);
//        model.addAttribute("category",list);
//            return new JSONObject(map);
        } catch (AuthorizationException e) {
//            e.printStackTrace();
//            map.put("errorMsg",StatusCodeContent.ACCOUNT_NO_AUTHORITY);
//            return new JSONObject(map);
            throw new BasicException("/admin/categoryadd", StatusCodeContent.ACCOUNT_NO_AUTHORITY);
        }
    }


    /**
     * @api {DELETE} /admin/categorydelete/:categoryid/  删除分类
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName 删除分类
     * @apiDescription 删除分类
     * @apiParam {Number} categoryid
     * @apiParamExample 拼接URL
     * 127.0.0.1/admin/categorydelete/7
     * @apiSuccessExample {json} Success-Response:
     * {
     * "errorMsg": "删除课程失败"
     * }
     */
    @RequestMapping("/categorydelete/{categoryid}")
    @ResponseBody
//    @RequiresRoles(value={"admin"}) 这个权限验证注释放在service里便于捕捉异常
    public JSONObject categorydelete(@PathVariable("categoryid") Long categoryid) throws AuthorizationException {

        HashMap map = new HashMap();
        try {
            boolean delFlag = categoryService.delete(categoryid);

            if (!delFlag) {
//                    map.put("errorMsg", StatusCodeContent.ADMIN_DELETECATEGORY_DELETEFAILURE);
//                    return new JSONObject(map);
                throw new BasicException(" /admin/categorydelete/:categoryid/", "删除失败");
            }
//                map.put("errorMsg", StatusCodeContent.ADMIN_DELETECATEGORY_DELETESUCCESS);
//                return new JSONObject(map);
            return Result.success(StatusCodeContent.ADMIN_DELETECATEGORY_DELETESUCCESS);
        } catch (AuthorizationException e) {
//                map.put("errorMsg",StatusCodeContent.ACCOUNT_NO_AUTHORITY);
//                return new JSONObject(map);
            throw new BasicException(" /admin/categorydelete/:categoryid/", StatusCodeContent.ACCOUNT_NO_AUTHORITY);
        }
    }


    /**
     * @api {POST} /admin/courseadd 增加课程
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName courseadd
     * @apiDescription 增加课程
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "title": "油画课6",
     * "keyword": "油画",
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1500,
     * "categoryid": 2,
     * "teacherid": 2,
     * "courseintro": "好课",
     * "abstracts": "haoaoahaohao"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample {json} Success-Response:
     * {
     * "errMsg": "添加课程失败"
     * }
     */
    @RequestMapping("/courseadd")
    @ResponseBody
    public JSONObject courseadd(@RequestBody JSONObject object) throws BasicException {

        HashMap map = new HashMap();

        Course course = JSONObject.toJavaObject(object, Course.class);
        if (!courseService.queryBytitle(course.getTitle()).isEmpty()) {
//            map.put("errMsg",StatusCodeContent.ADMIN_ADDCOURSE_ADDFALURE);
//            return new JSONObject(map);
            throw new BasicException("/admin/courseadd", StatusCodeContent.ADMIN_ADDCOURSE_ADDFALURE);
        }
        course.setJoined(0L);
        boolean inFlag = courseService.addCourse(course);
//        map.put("errMsg",StatusCodeContent.ADMIN_ADDCOURSE_ADDSUCCESS);

        if (!inFlag) {
            throw new BasicException("/admin/courseadd", StatusCodeContent.ADMIN_ADDCOURSE_ADDFALURE);
        }

        return Result.success(StatusCodeContent.ADMIN_ADDCOURSE_ADDSUCCESS);
    }


    /**
     * @api {DELETE} /admin/coursedelete/:courseid 删除课程
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName coursedelete
     * @apiDescription 删除课程
     * @apiParamExample 拼接字符串
     * {admin/coursedelete/9}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errMsg": "删除课程失败"
     * }
     */
    @RequestMapping("/coursedelete/{courseid}")
    @ResponseBody
    public JSONObject coursedelete(@PathVariable("courseid") Long courseid) throws BasicException {

        HashMap map = new HashMap();
        boolean delFlag = courseService.deleteByCourseid(courseid);
        if (!delFlag) {
//            map.put("errMsg",StatusCodeContent.ADMIN_DELETECOURSE_DELETEFAILURE);
            throw new BasicException("/admin/coursedelete/:courseid", StatusCodeContent.ADMIN_DELETECOURSE_DELETEFAILURE);
        }
        return Result.success(StatusCodeContent.ADMIN_DELETECOURSE_DELETESUCCESS);
    }


    /**
     * @api {POST} /admin/courseupdate 更新课程
     * @apiVersion 0.0.1
     * @apiGroup AdminController
     * @apiName courseupdate
     * @apiDescription 更新课程
     * @apiParam (请求体) {Object} object
     * @apiParamExample 请求体示例
     * {
     * "courseid": 12,
     * "title": "油画课233",
     * "keyword": "油画",
     * "totalnum": 120,
     * "joined": 50,
     * "price": 1500,
     * "categoryid": 2,
     * "teacherid": 2,
     * "courseintro": "好课",
     * "abstracts": "haoaoahaohao"
     * }
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "errMsg": "更新课程成功"
     * }
     */
    @RequestMapping("/courseupdate")
    @ResponseBody
    public JSONObject courseupdate(@RequestBody JSONObject object) throws BasicException {

        HashMap map = new HashMap();

        Course course = JSONObject.toJavaObject(object, Course.class);
        if (courseService.queryBytitle(course.getTitle()) != null) {
            boolean upFlag = courseService.updatecourse(course);
//            map.put("errMsg",StatusCodeContent.ADMIN_UPDATECOURSE_ADDSUCCESS);
            if (!upFlag) {
                throw new BasicException("/admin/courseupdate", StatusCodeContent.ADMIN_UPDATECOURSE_ADDFALURE);
            }
            return Result.success(StatusCodeContent.ADMIN_UPDATECOURSE_ADDSUCCESS);
        } else {
//            map.put("errMsg",StatusCodeContent.ADMIN_UPDATECOURSE_ADDFALURE);
            throw new BasicException("/admin/courseupdate", StatusCodeContent.ADMIN_UPDATECOURSE_ADDFALURE);

        }
    }

    @RequestMapping("/teacheradd")
    @ResponseBody
    public JSONObject teacheradd(@RequestBody JSONObject object) throws BasicException {

        //这里还要返回生成的teacherid
        //teacher表还要完善  头像 作品 主要信息等
        HashMap<String, Object> map = new HashMap<>();
        IdGenerator generator = new IdGenerator();
        Long teacherid = generator.teacheridGenerator();
        Teacher teacher = JSONObject.toJavaObject(object, Teacher.class);
        //判断是否存在
        while ((teacherService.queryTeacherByTeacherid(teacherid)) != null) {
            teacherid = generator.teacheridGenerator();
        }
        teacher.setTeacherid(teacherid);
        boolean addFlag = teacherService.addTeacher(teacher);
        if (!addFlag) {
            throw new BasicException("/admin/teacheradd", "添加教师失败");
        }
        return Result.success(addFlag);
    }

    @RequestMapping("/teacherdelete/{teacherid}")
    @ResponseBody
    public JSONObject teacherdelete(@PathVariable("teacherid") Long teacherid) throws BasicException {

        HashMap<String, Object> map = new HashMap<>();
        boolean delFlag = teacherService.deleteTeacher(teacherid);
        if (!delFlag) {
            throw new BasicException("/admin/teacherdelete/{teacherid}", "删除教师失败");
        }
        return Result.success(delFlag);
    }

    @RequestMapping("/teacherupdate")
    @ResponseBody
    public JSONObject teacherupdate(@RequestBody JSONObject object) throws BasicException {
        HashMap<String, Object> map = new HashMap<>();
        Teacher teacher = JSONObject.toJavaObject(object, Teacher.class);
        boolean updFlag = teacherService.updateteacher(teacher);
        if (!updFlag) {
            throw new BasicException("/admin/teacherupdate", "更新教师失败");
        }

        return Result.success(updFlag);
    }


    @RequestMapping("/ans")
    @ResponseBody
    public String ans() {

        Admin admin = (Admin) SecurityUtils.getSubject().getSession(true).getAttribute("Admin");


        return "" + admin;
    }


    @RequestMapping("/tologin")
    public String tologin() {

//        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
//        attributes.addFlashAttribute("savedRequest",savedRequest);

        return "login.html";
    }

//    public static void main(String[] args){
//
//         SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
//
//         //来复习以下 1字符=1byte=8bits 16进制=8bits
//        //hax原理 8bits拆成两个4bits 高位补零=>16进制(8bits)=>hex编码  长度翻倍
//         String salt = randomNumberGenerator.nextBytes(3).toHex();
//
//         int length = salt.length();
//        System.out.println(salt);
//       System.out.println(length);
//    }
}

