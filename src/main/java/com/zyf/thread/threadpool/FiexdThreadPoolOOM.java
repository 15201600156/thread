package com.zyf.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FiexdThreadPoolOOM {
    private static ExecutorService executorService= Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        for (int i=0;i<Integer.MAX_VALUE;i++){
            executorService.execute(new SubThread());
        }
    }
}
class SubThread implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}