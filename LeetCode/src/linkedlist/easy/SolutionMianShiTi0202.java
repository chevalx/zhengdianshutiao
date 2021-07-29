package linkedlist.easy;

public class SolutionMianShiTi0202 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        ListNode post = head;
        for (int i = 0; i < k; i++) {
            post = post.next;
        }
        ListNode pre = head;
        while (post != null) {
            pre = pre.next;
            post = post.next;
        }
        return pre.val;
    }
}
