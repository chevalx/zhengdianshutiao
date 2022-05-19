package concurrency.xianchenchi;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * scheduleAtFixedRate() 以给定的速率启动线程，如果线程报异常，则停止执行后续的线程，如果线程执行花的时间比period参数长，
 * 后面的线程会延后执行，而不会并发执行，自始至终只有一个线程
 *
 * scheduleWithFixedDelay() 以给定的间隔启动线程，在第一个线程结束的delay秒之后再启动线程。如果线程报异常，则停止执行后续的线程。
 */
public class Main {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 6; i++) {
//            es.submit(new Task("" + i));
//        }
//        es.shutdown();
        ScheduledExecutorService es = Executors.newScheduledThreadPool(4);
        es.scheduleAtFixedRate(new Task("task x"), 0, 2, TimeUnit.SECONDS);
//        es.shutdown();
    }
}

class Task implements Runnable {
    private int index = 0;
    private static int COUNT = 0;

    private final String name;

    public Task(String name) {
        this.index = ++COUNT;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name + " index " + index);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name + " index " + index);
    }
}
