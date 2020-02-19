package com.xm.sbdemo1.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerator {

    private static Date date;
    private static Random random;
    private static SimpleDateFormat dateFormat;
    private static String pre;
    private static String suf;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public synchronized Long teacheridGenerator() {
        date = new Date();
        random = new Random();
        dateFormat = new SimpleDateFormat("yyMMdd");
        pre = dateFormat.format(date);
        suf = String.valueOf(random.nextInt(999 - 100 + 1) + 100);
        StringBuilder builder = new StringBuilder(pre);
        Long teacherid = Long.valueOf(builder.append(suf).toString());
        id = teacherid;
//        Thread.sleep(4000);
//        System.out.println("zzzz");
        return this.id;
    }

    public synchronized Long useridGenerator() {
        Long useridstr;
        random = new Random();
        useridstr = Long.valueOf(random.nextInt(1999999 - 1000000 + 1) + 1000000);
        id = useridstr;
        return this.id;
    }

    public synchronized String adminidGenerator() {
        String adminidstr;
        random = new Random();
        adminidstr = String.valueOf(random.nextInt(10099 - 10000 + 1) + 10000);
        return adminidstr;
    }
}
