package com.xm.sbdemo1.exceptionhandle;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandle {

    //这是throw抛出异常后的第一步
    //拦截自定异常BasicException 并执行返回
    @ResponseBody
    @ExceptionHandler(value = BasicException.class)
    public JSONObject basicExceptionHandeler(BasicException basicException) {

        if (basicException.getCode() == null) {
            //已知错误
            return Result.error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), basicException.getPath(), basicException.getInfo());
        }
        //未知错误
        if (basicException.getCode() == 500) {
            return Result.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg(), basicException.getPath(), "未知错误");
        }
        return Result.error(basicException.getCode(), basicException.getMsg(), basicException.getPath(), basicException.getInfo());

    }

}
