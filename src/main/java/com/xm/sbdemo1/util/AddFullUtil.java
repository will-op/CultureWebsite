package com.xm.sbdemo1.util;

import com.xm.sbdemo1.pojo.Course;

public class AddFullUtil {


//    public static final Integer FULL_CODE = 202;

    public static boolean judgeForJoind(Course course) {

        return course.getJoined().equals(course.getTotalnum());
    }
}
