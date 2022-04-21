package concurrency.wenti.kejianxin;

// 1. 本例描述可见性问题
// stop是共享变量
// 只有B向stop写入true这一事实被A线程看见时，A线程才能停止
// 导致的结果：
// A start running
// B start running
// B stop running
// 可以看到A没有停止而是继续运行了下去，但按理来说A应该能看到stop的变化进而停止执行
// 那么如何解决呢？（本质上还是共享变量带来的问题）
// 1. volatile
// 2. synchronized
// 3. 加锁(lock...)
// 4. AtomicBoolean

// 加了volatile以后的结果：
//A start running
//B start running
//B stop running
//A stop running


public class Main {
    static boolean stop = false; // 共享变量
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("A start running");
                while (!stop);
                System.out.println("A stop running");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                System.out.println("B start running");
                stop = true;
                System.out.println("B stop running");
            }
        }.start();
    }
}
