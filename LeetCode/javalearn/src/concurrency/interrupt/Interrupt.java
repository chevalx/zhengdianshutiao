package concurrency.interrupt;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        a.start();
        Thread.sleep(1000);
        a.interrupt();
    }
}
