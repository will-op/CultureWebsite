package com.xm.sbdemo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Teacher;
import com.xm.sbdemo1.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * @api {GET} /teacher/queryByTeacherId/{teacherid} 查询老师
     * @apiVersion 0.0.1
     * @apiGroup TeacherController
     * @apiName queryByTeacherId
     * @apiDescription 查询老师
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping("/queryByTeacherId/{teacherid}")
    public JSONObject queryByTeacherId(@PathVariable("teacherid") Long teacherid) {

        HashMap<String, Object> map = new HashMap<>();
        Teacher teacher = teacherService.queryTeacherByTeacherid(teacherid);
        map.put("teacher", teacher);
//        return new JSONObject(map);
        return Result.success(teacher);
    }
}
