package linkedlist.easy;

public class SolutionMianShiTi0201 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p != null) {
            ListNode pre = p;
            ListNode post = p.next;
            while (post != null) {
                if (post.val == p.val) {
                    pre.next = post.next;
                    post = post.next;
                } else {
                    pre = pre.next;
                    post = post.next;
                }
            }
            p = p.next;
        }
        return head;
    }
}
