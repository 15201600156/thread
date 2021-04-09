package com.zyf.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalNormalUsage01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <30; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String data = new ThreadLocalNormalUsage01().data(finalI);
                    System.out.println(data);
                }
            }).start();
            Thread.sleep(100);
        }


    }

    public String data(int seconds) {
        //参数单位是毫秒，从1970-1-1 00:00:00 GMT开始计时
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date);
    }
}
