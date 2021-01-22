package xiaojiang.thread;


public class TestFixThreadPool {

    static int count;
}

class LiftOff extends Thread {

    @Override
    public void run() {
        System.out.println("Thread ID:" + Thread.currentThread().getId() +
                ",获取当前count权限，当前count:" + TestFixThreadPool.count);

        TestFixThreadPool.count++;

        System.out.println("Thread ID:" + Thread.currentThread().getId() +
                ",操作count，当前count:" + TestFixThreadPool.count);
        System.out.println();
    }
}