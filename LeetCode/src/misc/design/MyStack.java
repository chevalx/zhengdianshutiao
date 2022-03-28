package misc.design;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> a;
    private Queue<Integer> b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        while (!a.isEmpty()) {
            b.offer(a.poll());
        }
        a.offer(x);
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
    }

    public int pop() {
        return a.poll();
    }

    public int top() {
        return a.peek();
    }

    public boolean empty() {
        return a.isEmpty();
    }
}
