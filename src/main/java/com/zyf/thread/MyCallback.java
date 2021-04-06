package com.zyf.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallback implements Callable {
    @Override
    public Object call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+",正在异步发送短信");
            Thread.sleep(3000);

        } catch (Exception e) {

        }
        return "异步发送短信";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获取当前线程返回结果
        FutureTask<String> futureTask=new FutureTask<>(new MyCallback());
        new Thread(futureTask).start();
        //等待我们的线程执行完成后获取返回结果
        System.out.println("result:"+futureTask.get());
    }
}
