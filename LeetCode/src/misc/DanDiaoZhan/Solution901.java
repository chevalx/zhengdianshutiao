package misc.DanDiaoZhan;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        stockSpanner.next(100);
        stockSpanner.next(80);
        stockSpanner.next(60);
        stockSpanner.next(70);
        stockSpanner.next(60);
        stockSpanner.next(75);
        stockSpanner.next(85);
    }
}

class StockSpanner {

    List<Integer> historyPrice = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    int count = -1;

    public StockSpanner() {

    }

    public int next(int price) {
        count++;
        historyPrice.add(price);
        while (!stack.isEmpty() && historyPrice.get(stack.peek()) < price) {
            stack.pop();
        }
        int spanCount;
        if (stack.isEmpty()) {
            spanCount = count + 1;
        } else {
            spanCount = count - stack.peek();
        }
        stack.push(count);
        return spanCount;
    }
}
