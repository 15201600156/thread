package com.zyf.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
     //   scheduledExecutorService.schedule(new ForLoop.Task(),5, TimeUnit.SECONDS);//5s后执行该线程
        scheduledExecutorService.scheduleAtFixedRate(new ForLoop.Task(),1,3,TimeUnit.SECONDS); // 第一次是1秒中创建线程，然后每隔3秒中创建一个线程
    }
}
