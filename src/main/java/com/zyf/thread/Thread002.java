package com.zyf.thread;

public class Thread002 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"我是子线程");

    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"我是主线程");
     //   new Thread(new Thread002()).start();  //第一种方式

//        new Thread(new Runnable() {           //第二种方式
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"我是子线程");
//
//            }
//        }).start();

        new Thread(()-> System.out.println(Thread.currentThread().getName()+"我是子线程")).start();  //第三种方式
    }
}
