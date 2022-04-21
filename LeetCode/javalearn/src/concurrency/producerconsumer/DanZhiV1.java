package concurrency.producerconsumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 单值缓冲区第一版代码
// 只有一个条件变量和一个锁
// 在只有一个消费者和一个生产者的情况下不会出现问题
// 两个消费者c1, c2和一个生产者p1时会出现问题。
// c1 -> start -> wait                                                                              -> wakeup -> consume -> FAULT
// c2                                                        -> start -> consume -> signal -> await
// p1                  -> start -> produce -> signal -> wait
// 解决方案 while 代替 if

public class DanZhiV1 {
    private static int loops = 10;

    // 单值缓冲区
    private static int singleBuffer = 0;
    private static int count = 0;  // 初始值，缓冲区内没有数据
    private static Lock mutex = new ReentrantLock();
    private static Condition condition = mutex.newCondition();


    public static void main(String[] args) {
        Runnable produce = new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consume = new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread p1 = new Thread(produce);
        Thread c1 = new Thread(consume);
        Thread c2 = new Thread(consume);
        p1.start();
        c1.start();
        c2.start();
    }

    public static void put(int value) {
        assert count == 0;
        count = 1;
        singleBuffer = value;
    }

    public static int get() {
        assert count == 1;
        count = 0;
        return singleBuffer;
    }

    public static void producer() throws InterruptedException {
        for (int i = 0; i < loops; i++) {
            mutex.lock();
            if (count == 1) {
                condition.await();
            }
            put(i);
            condition.signal();
            mutex.unlock();
        }
    }

    public static void consumer() throws InterruptedException {
        for (int i = 0; i< loops;i++) {
            mutex.lock();
            if (count == 0) {
                condition.await();
            }
            int tmp = get();
            condition.signal();
            System.out.println(tmp);
        }
    }
}
