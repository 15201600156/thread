package com.zyf.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * //CachedThreadPool  可缓存线程池，特点：无界线程池，具有自动回收线程的功能
 * //这里的弊端在于第二个参数maxinumPoolSize被设置为了Integer.MAX_VALUE，这可能会创建数量非常多的线程甚至导致OOM
 */
public class CachedThreadPool {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<100;i++){
            executorService.execute(new ForLoop.Task());
        }
    }
}
