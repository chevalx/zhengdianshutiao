package concurrency.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DuoZhiV3 {

    public static void main(String[] args) {
        final Queue2 queue = new Queue2(200);
        Runnable produce = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000; i++) {
                        queue.producer(i);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consume = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10000; i++) {
                        queue.consumer();
                    }
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
}


class Queue2 {
    private int MAX;
    private int[] buffer;

    private int fill = 0;
    private int use = 0;
    private int count = 0;

    private Lock mutex = new ReentrantLock();
    private Condition full = mutex.newCondition();
    private Condition empty = mutex.newCondition();

    public Queue2(int capacity) {
        this.MAX = capacity;
        buffer = new int[MAX];
    }

    private void put(int value) {
        buffer[fill] = value;
        fill = (fill + 1) % MAX;
        count++;
        System.out.printf("%s put %d in %d\n", Thread.currentThread().getName(), value, fill - 1);
    }

    private int get() {
        int tmp = buffer[use];
        use = (use + 1) % MAX;
        count--;
        System.out.printf("%s get %d in %d\n", Thread.currentThread().getName(), tmp, use - 1);
        return tmp;
    }

    public void producer(int value) throws InterruptedException {
        mutex.lock();
        while (count == MAX) {
            empty.await();
        }
        put(value);
        full.signal();
        mutex.unlock();
    }

    public void consumer() throws InterruptedException {
        mutex.lock();
        while (count == 0) {
            full.await();
        }
        int tmp = get();
        empty.signal();
        System.out.println(tmp);
    }
}