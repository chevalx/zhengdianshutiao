package concurrency.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DuoZhiV1 {
    private static int MAX = 100;
    private static int[] buffer = new int[MAX];
    private static int fill = 0;
    private static int use = 0;
    private static int count = 0;
    private static int loops = 10000;
    private static Lock mutex = new ReentrantLock();
    private static Condition full = mutex.newCondition();
    private static Condition empty = mutex.newCondition();

    private static void put(int value) {
        buffer[fill] = value;
        fill = (fill + 1) % MAX;
        count++;
        System.out.printf("%s put %d in %d\n", Thread.currentThread().getName(), value, fill - 1);
    }

    private static int get() {
        int tmp = buffer[use];
        use = (use + 1) % MAX;
        count--;
        System.out.printf("%s get %d in %d\n", Thread.currentThread().getName(), tmp, use - 1);
        return tmp;
    }

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

    public static void producer() throws InterruptedException {
        for (int i = 0; i < loops; i++) {
            mutex.lock();
            while (count == MAX) {
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
