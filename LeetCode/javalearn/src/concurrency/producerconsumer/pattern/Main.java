package concurrency.producerconsumer.pattern;

public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 55666).start();
        new MakerThread("MakerThread-3", table, 72456).start();
        new EaterThread("EaterThread-1", table, 16552).start();
        new EaterThread("EaterThread-2", table, 72544).start();
        new EaterThread("EaterThread-3", table, 24567).start();
        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
