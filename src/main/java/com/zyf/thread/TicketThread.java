package com.zyf.thread;

public class TicketThread implements Runnable {

    //票数为100张
    private   int count=10000;

    @Override
    public void run() {
        while (count>0)
        {
            ticket();
        }
    }

    public  synchronized  void ticket()
    {
        if (count>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"，正在出票第"+(10000-count+1)+"张");
            count--;
        }

    }
    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
//        new Thread(ticketThread,"窗口1").start();
//        new Thread(ticketThread,"窗口2").start();
        for (int i=0;i<10;i++){
            new Thread(ticketThread,"窗口"+i).start();

        }

    }
}
