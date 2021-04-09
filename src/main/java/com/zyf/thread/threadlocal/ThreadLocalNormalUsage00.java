package com.zyf.thread.threadlocal;

import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 两个线程打印日期
 */
public class ThreadLocalNormalUsage00 {
    public static void main(String[] args) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String data = new ThreadLocalNormalUsage00().data(10);
                            System.out.println(data);
                        }
                    }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String data = new ThreadLocalNormalUsage00().data(1000);
                System.out.println(data);
            }
        }).start();


    }
    public  String data(int seconds){
        //参数单位是毫秒，从1970-1-1 00:00:00 GMT开始计时
        Date date =new Date(1000*seconds);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return  dateFormat.format(date);
    }
}
