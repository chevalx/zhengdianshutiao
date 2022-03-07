package linkedlist.easy;

import linkedlist.base.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionJZOfferZXTJ27 {
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;
        Deque<Integer> stack = new LinkedList<>();
        while (p1 != null) {
            stack.push(p1.val);
            p1 = p1.next;
        }

        ListNode p2 = head;
        while (p2 != null) {
            if (p2.val != stack.pop()) {
                return false;
            }
            p2 = p2.next;
        }
        return true;
    }
}
