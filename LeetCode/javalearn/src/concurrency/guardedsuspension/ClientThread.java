package concurrency.guardedsuspension;

import java.util.Random;

public class ClientThread extends Thread {
    private final Random random;
    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue queue, String name, long seed) {
        super(name);
        this.requestQueue = queue;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = new Request("No. " + i);
            System.out.println(Thread.currentThread().getName() + " reqeusts " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
