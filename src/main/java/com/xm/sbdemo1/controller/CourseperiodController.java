package com.xm.sbdemo1.controller;


import com.alibaba.fastjson.JSONObject;
import com.xm.sbdemo1.exceptionhandle.Result;
import com.xm.sbdemo1.pojo.Courseperiod;
import com.xm.sbdemo1.service.CourseperiodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/period")
@CrossOrigin
public class CourseperiodController {

    @Autowired
    private CourseperiodService courseperiodService;


    /**
     * @api {GET} /period/periodOfCourse/:courseid/ 购买时课时列表
     * @apiVersion 0.0.1
     * @apiGroup CourseController
     * @apiName periodOfCourse
     * @apiDescription 购买时课时列表
     * @apiParam (请求体) {Number} courseid
     * @apiParamExample 请求体示例
     * {/period/periodOfCourse/1}
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "courseperiod": [
     * {
     * "courseperiodid": null,
     * "courseperiodname": "第一课时",
     * "courseid": 1,
     * "begintime": null
     * }
     * ],
     * "courseid": 1
     * }
     */
    @RequestMapping("/periodOfCourse/{courseid}")
    public JSONObject periodOfCourse(@PathVariable("courseid") Long courseid) {
        HashMap map = new HashMap();
        List<Courseperiod> courseperiods = courseperiodService.queryByCid(courseid);
        map.put("courseperiod", courseperiods);
        map.put("courseid", courseid);
//        JSONObject jsonObject = new JSONObject(map);

        return Result.success(courseperiods);
    }
}
