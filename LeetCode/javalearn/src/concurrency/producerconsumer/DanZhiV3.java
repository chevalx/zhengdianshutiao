package concurrency.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DanZhiV3 {
    private static int loops = 10000;
    // 单值缓冲区
    private static int singleBuffer = 0;
    private static int count = 0;  // 初始值，缓冲区内没有数据
    private static Lock mutex = new ReentrantLock();
    private static Condition full = mutex.newCondition();
    private static Condition empty = mutex.newCondition();


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
            while (count == 1) {
                empty.await();
            }
            put(i);
            full.signal();
            mutex.unlock();
        }
    }

    public static void consumer() throws InterruptedException {
        for (int i = 0; i< loops;i++) {
            mutex.lock();
            while (count == 0) {
                full.await();
            }
            int tmp = get();
            empty.signal();
            System.out.println(tmp);
        }
    }
}
