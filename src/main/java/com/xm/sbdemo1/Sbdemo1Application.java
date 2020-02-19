package com.xm.sbdemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 */

@SpringBootApplication
@MapperScan("com.xm.sbdemo1.dao")
public class Sbdemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbdemo1Application.class, args);

//        String cmd = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://localhost:8080/user/login";
//        Runtime run = Runtime.getRuntime();
//        try{
//            run.exec(cmd);
////            logger.debug("success");
//        }catch (Exception e){
//            e.printStackTrace();
////            logger.error(e.getMessage());
//        }
    }

}
