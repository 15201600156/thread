package com.zyf.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread003 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()+"我是线程池"));
    }
}
