package xiaojiang.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/*
通过实现ThreadPoolExecutor实现线程池，使用submit提交Callable任务
*/
public class CallableDemo {
    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 10;
    private static final Long LIVE_TIME = 1L;
    private static final int QUEUE_SIZE = 100;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                MIN_SIZE, MAX_SIZE, LIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy());
        ArrayList<Future<String>> futuresList = new ArrayList<>();
        Callable<String> callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            //提交任务到线程池
            Future<String> future = threadPoolExecutor.submit(callable);
            futuresList.add(future);
        }
        for (Future<String> fut : futuresList) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
    }
}

/*通过实现callable接口实现带返回值的任务
 * */
class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}

