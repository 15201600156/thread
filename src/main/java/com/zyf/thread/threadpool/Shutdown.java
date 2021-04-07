package com.zyf.thread.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 关闭线程池
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for (int i = 0; i <100; i++) {
            executorService.execute(new ShutdownTask());
        }
        Thread.sleep(1500);
//        System.out.println(executorService.isShutdown());
//        executorService.shutdown();
//        System.out.println(executorService.isShutdown());
//        System.out.println(executorService.isTerminated());
//        Thread.sleep(2000);
//        System.out.println(executorService.isTerminated());

//        boolean b = executorService.awaitTermination(3L, TimeUnit.SECONDS);
//        System.out.println(b);
        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println(runnables);
        //  executorService.execute(new ShutdownTask());

    }
}

class  ShutdownTask implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"线程被中断了");
        }
    }
}