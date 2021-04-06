package com.zyf.thread;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class Thread001 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"我是子线程");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"我是主线程");
        new Thread001().start();
    }
}

