package concurrency.wenti.youxuxin;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 1000_00000; i++) {
            final State state = new State();
            // 初始值
            // a = 0, b = 0, c = 0

            // 针对 a b c 变量的写操作
            new Thread(() -> {
                state.a = 1;
                // a = 1, b = 0, c = 0
                state.b = 1;
                // a = 1, b = 1, c = 0
                state.c = state.a + 1;
                // a = 1, b = 1, c = 2
            }).start();

            // 读操作
            // Read values - this should nev                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  er happen, right?
            new Thread(() -> {
                // copy in reverse order so if we see some invalid state we know this is caused by reordering and
                // not by a race condition in reads/writes
                // we don't know if the reordered statements are the writes or reads (we will se it is writes later)
                // 如果写线程的执行顺序与代码编写顺序一样，那么倒序读取的tmpC，tmpB，tmpA的结果应该是完全满足顺序的，即b为1 的时候
                // a也一定为1；c为2的时候b和a一定为1。
                int tmpC = state.c;
                int tmpB = state.b;
                int tmpA = state.a;

                // 如果这里打印出来数据，则表示写操作出现了乱序
                if (tmpB == 1 && tmpA == 0) {
                    System.out.println("Hey wtf!! b == 1 && a == 0");
                }
                if (tmpC == 2 && tmpB == 0) {
                    System.out.println("Hey wtf!! c == 2 && b == 0");
                }
                if (tmpC == 2 && tmpA == 0) {
                    System.out.println("Hey wtf!! c == 2 && a == 0");
                }
            }).start();

        }
        System.out.println("done");
    }

    static class State {
        volatile int a = 0;
        volatile int b = 0;
        volatile int c = 0;
    }
}
