package linkedlist.medium;

import linkedlist.base.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode p1 = l1; ListNode p2 = l2;
        boolean overflow = false;
        while (p1 != null && p2 != null) {
            if (overflow) {
                cur.next = new ListNode(p1.val + p2.val + 1);
            } else {
                cur.next = new ListNode(p1.val + p2.val);
            }
            if (cur.next.val >= 10) {
                cur.next.val -= 10;
                overflow = true;
            } else {
                overflow = false;
            }
            p1 = p1.next;
            p2 = p2.next;
            cur = cur.next;
        }
        while (p1 != null) {
            cur.next = new ListNode(p1.val + (overflow ? 1 : 0));
            if (cur.next.val >= 10) {
                cur.next.val -= 10;
                overflow = true;
            } else {
                overflow = false;
            }
            p1 = p1.next;
            cur = cur.next;
        }
        while (p2 != null) {
            cur.next = new ListNode(p2.val + (overflow ? 1 : 0));
            if (cur.next.val >= 10) {
                cur.next.val -= 10;
                overflow = true;
            } else {
                overflow = false;
            }
            p2 = p2.next;
            cur = cur.next;
        }
        if (overflow) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
