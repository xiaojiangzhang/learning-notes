package com.xiaojiang.java.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建一个使用单个worder线程的executor，以无界队列方式来运行
 */
public class TestSingleThreadPool {
    public static ExecutorService executorService;

    static {
        executorService = Executors.newSingleThreadExecutor();
    }

    public static ExecutorService getSingleThreadPool() {
        return executorService;
    }
}

class TestSinglePool {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = TestSingleThreadPool.getSingleThreadPool();
        TestThread2 testThread2 = new TestThread2();
        TestThread2 testThread3 = new TestThread2();
        TestThread2 testThread4 = new TestThread2();
        TestThread2 testThread5 = new TestThread2();
        singleThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在执行");
            }
        });
        singleThreadPool.execute(testThread2);
        singleThreadPool.execute(testThread3);
        singleThreadPool.execute(testThread4);
        singleThreadPool.execute(testThread5);
        singleThreadPool.shutdown();
        new TestSataic();
        new TestSataic();
        new TestSataic();
    }
}

class TestThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行");
    }
}

class TestSataic {
    static {
        System.out.println("静态代码块执行");
    }

}