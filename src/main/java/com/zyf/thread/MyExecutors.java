package com.zyf.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MyExecutors {
    private List<WorkThread> workThreadList;


    private BlockingDeque<Runnable> runnableDeque;

    public MyExecutors(int maxThreadCount, int dequeSize) {
        runnableDeque = new LinkedBlockingDeque<Runnable>(dequeSize);
        workThreadList = new ArrayList<WorkThread>(maxThreadCount);
        for (int i = 0; i <maxThreadCount; i++) {
            new WorkThread().start();
        }

    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable runnable = runnableDeque.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    public boolean execute(Runnable command) {
        return runnableDeque.offer(command);
    }

    public static void main(String[] args) {
        MyExecutors myExecutors = new MyExecutors(2, 2);
        for (int i = 0; i < 10; i++) {
          final   int finalI = i;
            myExecutors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "," + finalI);
                }
            });
        }
    }
}
