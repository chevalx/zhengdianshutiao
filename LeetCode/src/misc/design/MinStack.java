package misc.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinStack {
    private PriorityQueue<Integer> minHeap;
    private Deque<Integer> stack;

    public MinStack() {
        minHeap = new PriorityQueue<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        minHeap.offer(val);
    }

    public void pop() {
        Integer peek = stack.peek();
        minHeap.remove(peek);
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minHeap.peek();
    }
}
