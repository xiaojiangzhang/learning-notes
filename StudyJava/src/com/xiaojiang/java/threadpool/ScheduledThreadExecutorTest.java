package com.xiaojiang.java.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutorTest {
    public static void main(String[] args) {
        Runnable myRunnable = new myThread();

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(myRunnable, 1000, 5000, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(new myThread2(), 1000, 2000, TimeUnit.MILLISECONDS);
    }

}

class myThread implements Runnable {
    @Override
    public void run() {
        System.out.println("-----" + System.nanoTime() + ":" + Thread.currentThread().getName() + "正在执行");

    }
}


class myThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("-----" + System.nanoTime());

    }
}
