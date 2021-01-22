package xiaojiang.thread;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*线程池的四种拒绝策略
ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
* */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 8;
    private static final int QUEUE_CAPACITY = 10;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        /*使用ThreadPoolExecutor创建线程池，
        通过ThreadPoolExecutor构造函数指定：
        CORE_POOL_SIZE 核心线程数线程数定义了最小可以同时运行的线程数量。
        MAX_POOL_SIZE 线程池最大线程数量
        QUEUE_CAPACITY 无界队列最大容量
        KEEP_ALIVE_TIME 大于CORE_POOL_SIZE线程数量的线程空闲线程最大存活时间，
        ArrayBlockingQueue 无界队列
        线程池的拒绝策略：CallerRunsPolicy（当超过）
        * */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new MyRunnable(i));
        }
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){

        }
        System.out.println("Finished all threads");

    }
}

/*
实现一个Runnable类
* */
class MyRunnable implements Runnable {
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
//        打印执行当前任务的时间和任务id
        System.out.println(Thread.currentThread().getName() + ", Task_id:" + id);
        processCommand();
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}