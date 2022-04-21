package concurrency.producerconsumer.pattern;

import java.util.Arrays;

public class Table {
    private final String[] buffers;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        this.buffers = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffers.length) {
            System.out.println(Thread.currentThread().getName() + " is waiting... ");
            wait();
        }
        buffers[tail] = cake;
        tail = (tail + 1) % buffers.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println(Thread.currentThread().getName() + " is waiting... ");
            wait();
        }
        String cake = buffers[head];
        head = (head + 1) % buffers.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    public synchronized void clear() {
        System.out.println(Thread.currentThread().getName() + " CLEAR ALL.");
        Arrays.fill(buffers, null);
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        notifyAll();
    }
}
