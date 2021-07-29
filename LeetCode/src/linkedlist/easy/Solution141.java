package linkedlist.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        List<Integer> hash = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            hash.add(cursor.hashCode());
            cursor = cursor.next;
            if (cursor == null) {
                return false;
            }
            if (hash.contains(cursor.hashCode())) {
                return true;
            }
        }

        return false;
    }

    public boolean answer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
