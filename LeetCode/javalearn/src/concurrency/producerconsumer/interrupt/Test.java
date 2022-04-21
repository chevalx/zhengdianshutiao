package concurrency.producerconsumer.interrupt;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread alice = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Monitor monitor = new Monitor();
                        monitor.fun();
                        System.out.println(Thread.interrupted());
                    }
                } catch (InterruptedException e) {
                    System.out.println("being interrupted.");
                    e.printStackTrace();
                }
            }
        };
        alice.start();
        Thread.sleep(1000);
        System.out.println(alice.isInterrupted());
        alice.interrupt();
        System.out.println(alice.isInterrupted());
    }
}

class Monitor {
    public synchronized void fun() throws InterruptedException {
        wait();
    }
}
