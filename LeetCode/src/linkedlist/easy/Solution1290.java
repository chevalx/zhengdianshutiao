package linkedlist.easy;

import java.util.LinkedList;

public class Solution1290 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int decimal = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        int power = 0;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            decimal += pop*Math.pow(2, power++);
        }
        return decimal;
    }
}
