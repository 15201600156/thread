package com.zyf.thread.threadpool;

import org.springframework.scheduling.config.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<100;i++){
            executorService.execute(new ForLoop.Task());
        }
    }
}
