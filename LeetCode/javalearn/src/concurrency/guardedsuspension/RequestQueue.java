package concurrency.guardedsuspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用GuardedSuspension模式实现的阻塞队列，实际上也是消费者生产者模型
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println(Thread.currentThread().getName() + " release and wait.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println(Thread.currentThread().getName() + " notify others.");
        notifyAll();
    }
}
