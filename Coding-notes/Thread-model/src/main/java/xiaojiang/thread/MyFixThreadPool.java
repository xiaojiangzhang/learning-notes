package xiaojiang.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建固定大小线程池
 */
public class MyFixThreadPool {
    private static ExecutorService fixThreadPool;

    /*
    静态代码块，初始化MyFixThreadPool时，执行一次，初始化fixThreadPool，并设置fixedThreadPool数量
     */
    static {
        fixThreadPool = Executors.newCachedThreadPool();
    }

    /*返回线程池对象*/
    public static ExecutorService getFixThreadPool() {
        return fixThreadPool;
    }


}
