package concurrency.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 仍然有问题
// p1                               start -> produce -> signal -> await
// c1 start -> await                                                    -> consume -> signal -> await
// c2                start -> await                                                                   -> start -> await
// 此时导致三个线程都在睡眠
// 问题在于一个线程signal的时候，不知道去唤醒哪一类线程（是唤醒消费者还是唤醒生产者？）
// 解决方法是使用两个条件变量
public class DanZhiV2 {
    private static int loops = 100000;
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
            while (count == 1) {
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
            while (count == 0) {
                condition.await();
            }
            int tmp = get();
            condition.signal();
            System.out.println(tmp);
        }
    }
}
