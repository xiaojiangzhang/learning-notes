package com.xiaojiang.java.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Thread t1 = new Mythread();
        Thread t2 = new Mythread();
        Thread t3 = new Mythread();
        Thread t4 = new Mythread();
        Thread t5 = new Mythread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.shutdown();


    }
}

class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行");
    }
}
