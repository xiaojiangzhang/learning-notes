package xiaojiang.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class MyFixThreadPoolTest {

    @Test
    public void getFixThreadPool() throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(30);
        for(int i = 0; i < 1000; i++) {
            exec.execute(new LiftOff());
            Thread.sleep(1);
        }
        exec.shutdown();
    }

}