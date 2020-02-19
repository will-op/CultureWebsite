package com.xm.sbdemo1.exceptionhandle;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//规范异常
public class Result {

    public static JSONObject success(Object data) {

        HashMap<String, Object> hashMap = new LinkedHashMap<>();
        hashMap.put("code", 200);
        hashMap.put("msg", "ok");
        hashMap.put("data", data);

        return new JSONObject(hashMap);

    }

    public static JSONObject error(int code, String msg, String path, String info) {

        //hashmap无序 linkedhashmap类似双向链表 新元素追加在链表尾部
        Map<String, Object> hashMap = new LinkedHashMap<>();

        hashMap.put("code", code);
        hashMap.put("msg", msg);
        hashMap.put("path", path);
        hashMap.put("info", info);
//        jsonObject.put()
//        jsonObject.put("result",hashMap);

        return new JSONObject(hashMap);
    }


}
