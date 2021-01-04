package com.xiaojiang.java.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建固定大小线程池
 */
public class MyFixThreadPool {
    private static ExecutorService fixThreadPool;

    static {
        fixThreadPool = Executors.newFixedThreadPool(11);
    }

    public static ExecutorService getFixThreadPool() {
        return fixThreadPool;
    }

}

class Varity {

    public static int count = 0;

    public static void countPlus() {
        System.out.println("当前线程name:" + Thread.currentThread().getName()
                + ", count = " + count
                + ",count+=1" + ",count=" + (count + 1)
        );
        count += 1;

    }
}

class TestThread extends Thread {
    @Override
    public void run() {
//        try {
////            System.out.println(Thread.currentThread().getName() + "睡眠中");
//
////            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Varity.countPlus();
    }
//        System.out.println(Thread.currentThread().getName() + "正在执行");

}

class Test {
    public static void main(String[] args) {
        ExecutorService fixThreadPool = MyFixThreadPool.getFixThreadPool();
        int a = 0;
        while (a++ < 100) {
            fixThreadPool.execute(new TestThread());
        }
//        TestThread testThread1 = new TestThread();
//        TestThread testThread2 = new TestThread();
//        TestThread testThread3 = new TestThread();
//        TestThread testThread4 = new TestThread();
//        fixThreadPool.execute(testThread1);
//        fixThreadPool.execute(testThread2);
//        fixThreadPool.execute(testThread3);
//        fixThreadPool.execute(testThread4);
//        fixThreadPool.shutdown();
    }

}