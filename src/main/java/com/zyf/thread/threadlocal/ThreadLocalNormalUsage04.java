package com.zyf.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1000个打印任务 ，使用线程池打印 使用锁
 */
public class ThreadLocalNormalUsage04 {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            executorService.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    String data = new ThreadLocalNormalUsage04().data(finalI);
                    System.out.println(data);
                }
            }));
        }
        executorService.shutdown();

    }

    public String data(int seconds) {
        //参数单位是毫秒，从1970-1-1 00:00:00 GMT开始计时
        synchronized (this){
            Date date = new Date(1000 * seconds);
            String format=null;
            synchronized (ThreadLocalNormalUsage04.class){
                 format = dateFormat.format(date);
            }
            return format;
        }
    }
}
